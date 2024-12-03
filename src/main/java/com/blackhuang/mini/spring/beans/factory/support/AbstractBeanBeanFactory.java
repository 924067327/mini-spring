package com.blackhuang.mini.spring.beans.factory.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.FactoryBean;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor;
import com.blackhuang.mini.spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.*;

/**
 * @author blackhuang
 * @date 2024/11/27 15:05
 */
public abstract class AbstractBeanBeanFactory extends DefaultSingletonBeanRegister implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (Objects.nonNull(bean)) {
            return getObjectForBeanInstance(bean, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        bean = createBean(name, beanDefinition);
        return getObjectForBeanInstance(bean, name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        Object object = beanInstance;
        if (object instanceof FactoryBean<?> factoryBean) {
            if (factoryBean.isSingleton()) {
                // singleton 优先从缓存中获取
                object = factoryBeanObjectCache.get(beanName);
                if (Objects.isNull(object)) {
                    object = factoryBean.getObject();
                    factoryBeanObjectCache.put(beanName, object);
                }
            } else {
                // proto type 直接创建
                object = factoryBean.getObject();
            }
        }
        return object;
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
