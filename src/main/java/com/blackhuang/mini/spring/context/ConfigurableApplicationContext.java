package com.blackhuang.mini.spring.context;

import com.blackhuang.mini.spring.beans.BeansException;

/**
 * @author blackhuang
 * @date 2024/11/29 14:57
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;

    void close();

    void registerShutdownHook();

}
