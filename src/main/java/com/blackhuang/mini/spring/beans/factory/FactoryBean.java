package com.blackhuang.mini.spring.beans.factory;

/**
 * @author blackhuang
 * @date 2024/12/3 20:35
 */
public interface FactoryBean<T> {

    T getObject();

    boolean isSingleton();

}
