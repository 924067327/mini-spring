package com.blackhuang.mini.spring.context.event.caster;

import com.blackhuang.mini.spring.context.event.ApplicationEvent;

import java.util.EventListener;

/**
 * @author blackhuang
 * @date 2024/12/4 11:04
 */
public interface ApplicationEventListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);

}
