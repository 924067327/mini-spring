package com.blackhuang.mini.spring.bean;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor;

/**
 * @author blackhuang
 * @date 2024/11/28 21:16
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("invoke MyBeanPostProcessor.postProcessBeforeInitialization for bean: " + beanName);
        if (beanName.equals("blackhuang")) {
            Person person = (Person) bean;
            person.setName("blackhuang_before_initialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("invoke MyBeanPostProcessor.postProcessAfterInitialization for bean: " + beanName);
        return bean;
    }

}
