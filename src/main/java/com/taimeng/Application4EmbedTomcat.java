package com.taimeng;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;


//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
/**
 * SpringBoot调试入口，运行main入口会启动SpringBoot提供的内嵌tomcat，并扫描工程进行必要的
 * 配置类，进行自动装配和依赖注入等
 * 
 * @author gaoyong
 *
 */
@SpringBootApplication
@EnableJms
public class Application4EmbedTomcat {
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application4EmbedTomcat.class);
    }
}
