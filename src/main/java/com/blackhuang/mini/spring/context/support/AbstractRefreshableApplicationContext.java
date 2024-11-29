package com.blackhuang.mini.spring.context.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.ConfigListableBeanFactory;
import com.blackhuang.mini.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author blackhuang
 * @date 2024/11/29 16:14
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected final void refreshBeanFactory() throws BeansException {
        // TODO 只能刷新一次
        DefaultListableBeanFactory beanFactory = createListableBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected DefaultListableBeanFactory createListableBeanFactory() throws BeansException {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

    @Override
    protected ConfigListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
    
    
    
}
