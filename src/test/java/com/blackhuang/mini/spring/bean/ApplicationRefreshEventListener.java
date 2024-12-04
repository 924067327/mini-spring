package com.blackhuang.mini.spring.bean;

import com.blackhuang.mini.spring.context.event.ContextRefreshedEvent;
import com.blackhuang.mini.spring.context.event.caster.ApplicationEventListener;

/**
 * @author blackhuang
 * @date 2024/12/4 11:48
 */
public class ApplicationRefreshEventListener implements ApplicationEventListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("application context refreshed...");
    }
}
