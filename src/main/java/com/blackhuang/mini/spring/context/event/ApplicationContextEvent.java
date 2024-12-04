package com.blackhuang.mini.spring.context.event;

import com.blackhuang.mini.spring.context.ApplicationContext;

/**
 * @author blackhuang
 * @date 2024/12/4 10:59
 */
public class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(ApplicationContext source) {
        super(source);
    }

    public ApplicationContext getApplicationContext() {
        return (ApplicationContext) source;
    }

}
