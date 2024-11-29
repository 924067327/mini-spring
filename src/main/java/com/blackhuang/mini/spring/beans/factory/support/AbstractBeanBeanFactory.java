package com.blackhuang.mini.spring.beans.factory.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor;
import com.blackhuang.mini.spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author blackhuang
 * @date 2024/11/27 15:05
 */
public abstract class AbstractBeanBeanFactory extends DefaultSingletonBeanRegister implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (Objects.nonNull(bean)) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
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
