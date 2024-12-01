package com.blackhuang.mini.spring.context.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.blackhuang.mini.spring.beans.factory.config.BeanPostProcessor;
import com.blackhuang.mini.spring.beans.factory.config.ConfigListableBeanFactory;
import com.blackhuang.mini.spring.context.ConfigurableApplicationContext;
import com.blackhuang.mini.spring.core.io.DefaultResourceLoader;

import java.util.Collections;
import java.util.Map;

/**
 * @author blackhuang
 * @date 2024/11/29 14:58
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 创建 BeanFactory，加载 BeanDefinition
        refreshBeanFactory();
        ConfigListableBeanFactory beanFactory = getBeanFactory();

        // 执行 BeanFactory 加载完成回调
        invokeBeanFactoryPostProcessors(beanFactory);

        // 注册 BeanPostProcessor
        registerBeanPostProcessors(beanFactory);

        // 实例化Bean
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigListableBeanFactory getBeanFactory();

    protected void invokeBeanFactoryPostProcessors(ConfigListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> pm = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        pm.values().forEach(p -> p.postProcessBeanFactory(beanFactory));
    }

    protected void registerBeanPostProcessors(ConfigListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> pm = beanFactory.getBeansOfType(BeanPostProcessor.class);
        pm.values().forEach(beanFactory::addBeanPostProcessor);
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void close() {
        doClose();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::doClose));
    }

    protected void doClose() {
        destroyBeans();
    }

    protected void destroyBeans() {
        getBeanFactory().destroySingletons();
    }

}
