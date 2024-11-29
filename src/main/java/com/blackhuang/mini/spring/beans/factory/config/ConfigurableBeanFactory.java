package com.blackhuang.mini.spring.beans.factory.config;

import com.blackhuang.mini.spring.beans.factory.BeanFactory;

/**
 * BeanFactory 接口的扩展，提供 BeanFactory 的配置能力
 * 
 * @author blackhuang
 * @date 2024/11/28 20:39
 */
public interface ConfigurableBeanFactory extends BeanFactory, SingletonBeanRegister {

    /**
     * 添加bean处理器
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
