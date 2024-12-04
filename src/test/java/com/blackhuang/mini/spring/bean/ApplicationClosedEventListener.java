package com.blackhuang.mini.spring.bean;

import com.blackhuang.mini.spring.context.event.ContextClosedEvent;
import com.blackhuang.mini.spring.context.event.caster.ApplicationEventListener;

/**
 * @author blackhuang
 * @date 2024/12/4 11:48
 */
public class ApplicationClosedEventListener implements ApplicationEventListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("application context closed...");
    }
}
