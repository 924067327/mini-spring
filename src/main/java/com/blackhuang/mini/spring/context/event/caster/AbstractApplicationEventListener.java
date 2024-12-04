package com.blackhuang.mini.spring.context.event.caster;

import com.blackhuang.mini.spring.beans.BeanFactoryAware;
import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.BeanFactory;
import com.blackhuang.mini.spring.context.event.ApplicationEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author blackhuang
 * @date 2024/12/4 11:08
 */
public abstract class AbstractApplicationEventListener implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationEventListener<ApplicationEvent>> listeners = new HashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void addApplicationListener(ApplicationEventListener<ApplicationEvent> listener) {
        listeners.add(listener);
    }

    @Override
    public void removeApplicationListener(ApplicationEventListener<ApplicationEvent> listener) {
        listeners.remove(listener);
    }
}
