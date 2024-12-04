package com.blackhuang.mini.spring.context.event.caster;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.factory.BeanFactory;
import com.blackhuang.mini.spring.context.event.ApplicationEvent;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author blackhuang
 * @date 2024/12/4 11:12
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventListener {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multiCastEvent(ApplicationEvent event) {
        for (ApplicationEventListener<ApplicationEvent> listener : listeners) {
            if (supportsEvent(listener, event)) {
                listener.onApplicationEvent(event);
            }
        }
    }

    protected boolean supportsEvent(ApplicationEventListener<ApplicationEvent> listener, ApplicationEvent event) {
        Type type = listener.getClass().getGenericInterfaces()[0];
        Type actualTypeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
        return eventClassName.isAssignableFrom(event.getClass());
        
    }

}
