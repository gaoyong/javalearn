package com.taimeng.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by gaoyong on 2016/12/21.
 */
@Service
public class TestService implements BeanSelfAware{
    private TestService proxySelf ;

    public static final String DEMO_KEY = "demo";

    public static final String DEMO_KEY2 = "demo2";

    @Cacheable(value = "test", key = "#root.target.DEMO_KEY.concat(#string.toString())")
    public String echoStr(String string){
//        System.out.println(" action : echonStr at" + new Date());
//        return proxySelf.echoStr2(string) + "-value";
        TestService proxy =  (TestService) (AopContext.currentProxy());
        return proxy.echoStr2(string) + "-value";
    }

    @Cacheable(value = "test", key = "#root.target.DEMO_KEY2.concat(#string.toString())")
    public String echoStr2(String string){
        System.out.println(" action : echonStr2 at" + new Date());
        return string + "-value";
    }

    @Override
    public void setSelf(Object proxyBean) {
        this.proxySelf = (TestService)proxyBean;
    }
}
