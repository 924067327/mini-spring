package com.blackhuang.mini.spring.factory.config;

/**
 * @author blackhuang
 * @date 2024/11/27 15:34
 */
public interface BeanDefinitionRegister {
    
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    
}
