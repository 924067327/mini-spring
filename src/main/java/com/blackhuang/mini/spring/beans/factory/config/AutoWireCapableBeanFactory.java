package com.blackhuang.mini.spring.beans.factory.config;

import com.blackhuang.mini.spring.beans.factory.BeanFactory;

/**
 * @author blackhuang
 * @date 2024/11/28 20:46
 */
public interface AutoWireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 {@link com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization}
     */
    Object applyBeanPostProcessorsBeforeInstantiation(Object bean, String beanName);

    /**
     * 执行 {@link com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization}
     */
    Object applyBeanPostProcessorsAfterInstantiation(Object bean, String beanName);

}