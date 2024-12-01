package com.blackhuang.mini.spring.beans;

import com.blackhuang.mini.spring.beans.factory.BeanFactory;

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
