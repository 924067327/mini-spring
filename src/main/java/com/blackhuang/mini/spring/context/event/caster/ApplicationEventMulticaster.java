package com.blackhuang.mini.spring.context.event.caster;

import com.blackhuang.mini.spring.context.event.ApplicationEvent;

/**
 * @author blackhuang
 * @date 2024/12/4 11:02
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationEventListener<ApplicationEvent> listener);

    void removeApplicationListener(ApplicationEventListener<ApplicationEvent> listener);

    void multiCastEvent(ApplicationEvent event);

}
