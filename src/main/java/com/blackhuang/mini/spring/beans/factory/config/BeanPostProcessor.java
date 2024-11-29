package com.blackhuang.mini.spring.beans.factory.config;

import com.blackhuang.mini.spring.beans.BeansException;

/**
 * @author blackhuang
 * @date 2024/11/28 20:41
 */
public interface BeanPostProcessor {

    /**
     * bean执行init方法前执行此方法
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * bean执行init方法后执行此方法
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
