package com.blackhuang.mini.spring.bean;

import com.blackhuang.mini.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.blackhuang.mini.spring.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author blackhuang
 * @date 2024/11/29 17:23
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableBeanFactory beanFactory) {
        System.out.println("invoke postProcessBeanFactory...");
    }
}
