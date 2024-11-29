package com.blackhuang.mini.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.PropertyValue;
import com.blackhuang.mini.spring.beans.factory.config.AutoWireCapableBeanFactory;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor;
import com.blackhuang.mini.spring.beans.factory.config.BeanReference;

/**
 * @author blackhuang
 * @date 2024/11/27 15:29
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanBeanFactory implements AutoWireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        return doCreateBean(name, beanDefinition);
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInstantiation(Object bean, String beanName) {
        Object result = bean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                break;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInstantiation(Object bean, String beanName) {
        Object result = bean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                break;
            }
            result = current;
        }
        return result;
    }

    protected Object doCreateBean(String name, BeanDefinition beanDefinition) {
        Object bean;
        try {
            // 实例化
            bean = instantiationStrategy.instantiate(beanDefinition);
            // 填充属性
            applyPropertyValues(name, bean, beanDefinition);
            // 初始化
            bean = initializeBean(name, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("newInstance bean fail", e);
        }
        addSingleton(name, bean);
        return bean;
    }

    protected Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {

        // 初始化前置钩子函数
        Object warpedBean = applyBeanPostProcessorsBeforeInstantiation(bean, beanName);

        // 初始化bean
        invokeInitialMethod(beanName, warpedBean, beanDefinition);

        // 初始化后置钩子函数
        warpedBean = applyBeanPostProcessorsAfterInstantiation(warpedBean, beanName);

        return warpedBean;
    }

    protected void invokeInitialMethod(String beanName, Object bean, BeanDefinition beanDefinition) {
        System.out.println("invokeInitialMethod for " + beanName);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                // 注入bean依赖
                if (value instanceof BeanReference) {
                    BeanReference ref = (BeanReference) value;
                    value = getBean(ref.getBeanName());
                }
                BeanUtil.setProperty(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("apply property values error for bean: " + beanName, e);
        }
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

}
