package edu.tsinghua.gaoyong.activemq.stomp;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.fusesource.stomp.jms.*;
import javax.jms.*;

/**
 * 此程序为activemq的stomp的实例，为订阅方
 * 先运行同一package的Publisher发布服务，然后消息订阅方就可以执行
 *
 */
class Listener {

    public static void main(String []args) throws JMSException {

        String user = env("ACTIVEMQ_USER", "admin");
        String password = env("ACTIVEMQ_PASSWORD", "password");
        String host = env("ACTIVEMQ_HOST", "localhost");
        //问题是为何使用61613端口,为何不使用61616端口,而且发现一个问题使用61614也会报错?
//        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61613"));
        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61613"));
        String destination = arg(args, 0, "/topic/event");

        StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
        factory.setBrokerURI("tcp://" + host + ":" + port);
        System.out.println("BrokerURI is : tcp://" + host + ":" + port);

        Connection connection = factory.createConnection(user, password);
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination dest = new StompJmsDestination(destination);

        MessageConsumer consumer = session.createConsumer(dest);
        long start = System.currentTimeMillis();
        long count = 1;
        System.out.println("Waiting for messages...");
        while(true) {
            Message msg = consumer.receive();
            if( msg instanceof  TextMessage ) {
                String body = ((TextMessage) msg).getText();
                if( "SHUTDOWN".equals(body)) { //中止监听的约定
                    long diff = System.currentTimeMillis() - start;
                    System.out.println(String.format("Received %d in %.2f seconds", count, (1.0*diff/1000.0)));
                    break;
                } else {
                    if( count != msg.getIntProperty("id") ) {
                        System.out.println("mismatch: "+count+"!="+msg.getIntProperty("id"));
                    }
                    count = msg.getIntProperty("id");

                    if( count == 0 ) {
                        start = System.currentTimeMillis();
                    }
                    if( count % 1000 == 0 ) { //挑取一部分mq发送的信息进行输出，挑取的特征是1000 2000 这样的整数
                        System.out.println(String.format("Received %d messages.", count));
                        System.out.println("\t wrapper data:" + msg.getIntProperty("id"));
                        System.out.println("\t wrapper properties id :" + msg.getIntProperty("id"));
                    }
                    count ++;
                }

            } else {
                System.out.println("Unexpected message type: "+msg.getClass());
            }
        }
        connection.close();
    }

    private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if( rc== null )
            return defaultValue;
        return rc;
    }

    private static String arg(String []args, int index, String defaultValue) {
        if( index < args.length )
            return args[index];
        else
            return defaultValue;
    }
}
