package com.blackhuang.mini.spring.context.event;

import java.util.EventObject;

/**
 * @author blackhuang
 * @date 2024/12/4 10:56
 */
public class ApplicationEvent extends EventObject {
    
    public ApplicationEvent(Object source) {
        super(source);
    }
}
