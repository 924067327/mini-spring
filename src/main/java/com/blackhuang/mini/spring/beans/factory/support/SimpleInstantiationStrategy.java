package com.blackhuang.mini.spring.beans.factory.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;

/**
 * @author blackhuang
 * @date 2024/11/28 9:48
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            return beanClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new BeansException("newInstance bean fail for " + beanClass.getName(), e);
        }
    }
}
