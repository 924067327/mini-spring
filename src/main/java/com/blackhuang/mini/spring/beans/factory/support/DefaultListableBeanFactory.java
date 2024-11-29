package com.blackhuang.mini.spring.beans.factory.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinitionRegistry;
import com.blackhuang.mini.spring.beans.factory.config.ConfigListableBeanFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author blackhuang
 * @date 2024/11/27 15:40
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements ConfigListableBeanFactory, BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (Objects.isNull(beanDefinition)) {
            throw new BeansException("No bean with name " + beanName + " found");
        }
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> resultMap = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            if (type.isAssignableFrom(beanDefinition.getBeanClass())) {
                resultMap.put(beanName, (T) getBean(beanName));
            }
        });
        return resultMap;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
