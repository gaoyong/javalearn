package com.taimeng.controller;

import com.google.common.collect.Lists;

import com.taimeng.service.TestService;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * Created by gaoyong on 2016/12/12.
 */
@RestController
@RequestMapping(value = "api/test")
public class TestController {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private TestService testService;

    @Resource
    private RedisTemplate redisTemplate;


    @RequestMapping("/api/redis")
    @ResponseBody
    public String redis() {
        String setKey = "testRedis";
        StopWatch watch = new StopWatch("Redis Test");
        int number = 100000;
        watch.start("testRedis");
        List valueList = Lists.newArrayListWithCapacity(number);
        for (int i = 0; i < number; i++) {
            valueList.add("value" + i);
        }
        redisTemplate.opsForList().leftPushAll(setKey, valueList);
        watch.stop();
        logger.info(watch.prettyPrint());
        return "okay";
    }

    @RequestMapping("/redis/mset")
    @ResponseBody
    public String mset() {
        Map map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");


        redisTemplate.opsForValue().multiSet(map);
        RedisSerializer valueSerializer = redisTemplate.getValueSerializer();
        System.out.println(valueSerializer.getClass());
        return "success";
    }

    @RequestMapping("/redis/template/jackson")
    @ResponseBody
    public String setRedisTemplate2Jackson(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return "jackon";
    }

    @RequestMapping("/redis/template/string")
    @ResponseBody
    public String setRedisTemplate2String(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return "string";
    }

    @RequestMapping("/redis/mget")
    @ResponseBody
    public String mget() {
        //第一种初始化List方法
        List<String> keys = Arrays.asList("k1","k2","k3");
        //第二种初始化List方法
//        keys = ImmutableList.of("k1","k2","k3");

        List values = redisTemplate.opsForValue().multiGet(keys);
        StringBuffer sb = new StringBuffer("Value");
        values.stream().forEach(v -> sb.append("-").append(v.toString()));

        return sb.toString();
    }

//    @Autowired
//    private OkHttpClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test() throws Exception{
//        Request request = new Request.Builder().url("http://localhost:9091/bar").get().build();  //service3
//        Response response = client.newCall(request).execute();
//        String result = response.body().string();
        String result = "hello-world";

        return result;
    }

    /**
     * 测试SpringCache的Object内调用自身方法的问题
     * @param value
     * @return
     */
    @RequestMapping("/api/test/{value}")
    @ResponseBody
    public String cacheTest(@PathVariable String value) {
        return testService.echoStr(value);
    }
}
