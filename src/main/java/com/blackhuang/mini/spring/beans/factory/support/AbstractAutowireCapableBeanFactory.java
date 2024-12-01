package com.blackhuang.mini.spring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.PropertyValue;
import com.blackhuang.mini.spring.beans.factory.DisposableBean;
import com.blackhuang.mini.spring.beans.factory.InitializingBean;
import com.blackhuang.mini.spring.beans.factory.config.AutoWireCapableBeanFactory;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor;
import com.blackhuang.mini.spring.beans.factory.config.BeanReference;

import java.lang.reflect.Method;

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

        // 注册销毁方法
        registerDisposableBeanIfNecessary(name, bean, beanDefinition);

        // 注册
        addSingleton(name, bean);
        return bean;
    }

    protected Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {

        // 初始化前置钩子函数
        Object warpedBean = applyBeanPostProcessorsBeforeInstantiation(bean, beanName);

        // 初始化bean
        try {
            invokeInitialMethod(beanName, warpedBean, beanDefinition);
        } catch (Throwable e) {
            throw new BeansException("invokeInitialMethod bean fail: " + beanName, e);
        }

        // 初始化后置钩子函数
        warpedBean = applyBeanPostProcessorsAfterInstantiation(warpedBean, beanName);

        return warpedBean;
    }

    protected void invokeInitialMethod(String beanName, Object bean, BeanDefinition beanDefinition) throws Throwable {
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(bean instanceof InitializingBean && initMethodName.equals("afterPropertiesSet"))) {
            Method initMethod = ClassUtil.getPublicMethod(beanDefinition.getBeanClass(), initMethodName);
            if (initMethod != null) {
                initMethod.invoke(bean);
            } else {
                throw new BeansException("Bean [" + beanName + "] has no init-method [" + initMethodName + "]");
            }
        }
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition.getDestroyMethodName()));
        }
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

}
