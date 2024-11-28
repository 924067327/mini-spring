package com.blackhuang.mini.spring.factory.support;

import com.blackhuang.mini.spring.factory.BeansException;
import com.blackhuang.mini.spring.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.factory.config.BeanDefinitionRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author blackhuang
 * @date 2024/11/27 15:40
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }


    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (Objects.isNull(beanDefinition)) {
            throw new BeansException("No bean with name " + beanName + " found");
        }
        return beanDefinition;
    }
}
