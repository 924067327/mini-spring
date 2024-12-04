package com.blackhuang.mini.spring.context.event;

import com.blackhuang.mini.spring.context.ApplicationContext;

/**
 * @author blackhuang
 * @date 2024/12/4 11:00
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(ApplicationContext source) {
        super(source);
    }
    
}
