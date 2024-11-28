package com.blackhuang.mini.spring.beans.factory;

import com.blackhuang.mini.spring.beans.BeansException;

/**
 * @author blackhuang
 * @date 2024/11/27 14:57
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
