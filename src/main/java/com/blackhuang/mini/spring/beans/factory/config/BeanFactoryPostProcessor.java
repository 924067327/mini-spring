package com.blackhuang.mini.spring.beans.factory.config;

/**
 * @author blackhuang
 * @date 2024/11/28 20:43
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在beanFactory加载完成之后调用，提供对BeanDefinition修改的机制
     */
    void postProcessBeanFactory(ConfigurableBeanFactory beanFactory);

}
