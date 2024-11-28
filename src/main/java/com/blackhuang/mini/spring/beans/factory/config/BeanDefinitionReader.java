package com.blackhuang.mini.spring.beans.factory.config;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.core.io.Resource;
import com.blackhuang.mini.spring.core.io.ResourceLoader;

/**
 * 读取bean定义接口
 *
 * @author blackhuang
 * @date 2024/11/28 16:55
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
