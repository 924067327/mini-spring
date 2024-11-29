package com.blackhuang.mini.spring.context.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor;
import com.blackhuang.mini.spring.context.ApplicationContext;
import lombok.AllArgsConstructor;

/**
 * @author blackhuang
 * @date 2024/11/29 15:07
 */
@AllArgsConstructor
public class ApplicationAwareProcessor implements BeanPostProcessor {
    
    private final ApplicationContext applicationContext;
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
