package com.blackhuang.mini.spring.beans.factory.support;

import com.blackhuang.mini.spring.beans.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.Map;

/**
 * @author blackhuang
 * @date 2024/11/27 15:02
 */
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {

    private final Map<String, Object> singletonBeanMap = new HashMap<String, Object>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object bean) {
        singletonBeanMap.put(beanName, bean);
    }

}
