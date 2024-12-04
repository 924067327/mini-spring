package com.blackhuang.mini.spring.context.event;

import com.blackhuang.mini.spring.context.ApplicationContext;

/**
 * @author blackhuang
 * @date 2024/12/4 11:02
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(ApplicationContext source) {
        super(source);
    }
    
}
