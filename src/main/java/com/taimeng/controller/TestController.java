package com.taimeng.controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaoyong on 2016/12/12.
 */
@RestController
@RequestMapping(value = "api/test")
public class TestController {

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
}
