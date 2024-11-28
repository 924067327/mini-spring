package com.blackhuang.mini.spring.beans.factory.config;

/**
 * 单例bean注册
 *
 * @author blackhuang
 * @date 2024/11/27 15:01
 */
public interface SingletonBeanRegister {

    Object getSingleton(String beanName);

}
