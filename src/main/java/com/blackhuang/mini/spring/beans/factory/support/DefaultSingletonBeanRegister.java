package com.blackhuang.mini.spring.beans.factory.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.DisposableBean;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.beans.factory.config.SingletonBeanRegister;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @author blackhuang
 * @date 2024/11/27 15:02
 */
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {

    private final Map<String, Object> singletonBeanMap = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object bean) {
        singletonBeanMap.put(beanName, bean);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeanMap.put(beanName, bean);
    }

    public void destroySingletons() {
        disposableBeanMap.keySet().forEach(beanName -> {
            DisposableBean destroyBean = disposableBeanMap.remove(beanName);
            try {
                destroyBean.destroy();
            } catch (Exception e) {
                throw new BeansException("destroy bean error, bean: " + beanName, e);
            }
        });
    }

}
