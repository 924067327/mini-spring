package com.blackhuang.mini.spring.context.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor;
import com.blackhuang.mini.spring.context.ApplicationContext;
import com.blackhuang.mini.spring.context.ApplicationContextAware;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
