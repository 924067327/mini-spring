package com.blackhuang.mini.spring.beans.factory.config;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.ListableBeanFactory;

/**
 * @author blackhuang
 * @date 2024/11/29 15:21
 */
public interface ConfigListableBeanFactory extends ListableBeanFactory, AutoWireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void destroySingletons();

}
