package com.blackhuang.mini.spring.beans.factory.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;

/**
 * @author blackhuang
 * @date 2024/11/28 9:47
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
