package com.blackhuang.mini.spring.beans.factory;

import com.blackhuang.mini.spring.beans.BeansException;

import java.util.Map;

/**
 * BeanFactory 接口的扩展，可以枚举所有 bean 实例，而不是按照客户端的要求尝试通过名称一一查找 bean。
 * 
 * @author blackhuang
 * @date 2024/11/29 15:17
 */
public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();

}
