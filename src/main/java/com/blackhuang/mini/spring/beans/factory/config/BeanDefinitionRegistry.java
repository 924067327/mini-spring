package com.blackhuang.mini.spring.beans.factory.config;

import com.blackhuang.mini.spring.beans.BeansException;

/**
 * @author blackhuang
 * @date 2024/11/27 15:34
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();

}
