package com.blackhuang.mini.spring.factory.support;

import com.blackhuang.mini.spring.factory.BeansException;
import com.blackhuang.mini.spring.factory.BeanFactory;
import com.blackhuang.mini.spring.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @author blackhuang
 * @date 2024/11/27 15:05
 */
public abstract class AbstractBeanBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (Objects.nonNull(bean)) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     * 创建bean
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;

    /**
     * 获取bean定义类
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
