package com.taimeng.cfg;

import com.taimeng.service.BeanSelfAware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InjectBeanSelfProcessor implements BeanPostProcessor, ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(InjectBeanSelfProcessor.class.getSimpleName());

    private ApplicationContext context;

    //① 注入ApplicationContext
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    //Spring容器初始化的时候对各个Bean进行注入
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(!(bean instanceof BeanSelfAware)) { //② 如果Bean没有实现BeanSelfAware标识接口 跳过
            return bean;
        }
        if(AopUtils.isAopProxy(bean)) { //③ 如果当前对象是AOP代理对象，直接注入
            System.out.println("isAopProxy,注入对象 beanName =" + beanName + ",at " + new Date());
            logger.info("isAopProxy,注入对象 beanName = {} , 时间 at = {}" ,beanName ,new Date());
            ((BeanSelfAware) bean).setSelf(bean);
        } else {
            //④ 如果当前对象不是AOP代理，则通过context.getBean(beanName)获取代理对象并注入
            //此种方式不适合解决prototype Bean的代理对象注入
            System.out.println("注入对象 beanName =" + beanName + ",at " + new Date());
            logger.info("注入对象 beanName = {} , 时间 at = {}" ,beanName ,new Date());
            ((BeanSelfAware)bean).setSelf(context.getBean(beanName));
        }
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
