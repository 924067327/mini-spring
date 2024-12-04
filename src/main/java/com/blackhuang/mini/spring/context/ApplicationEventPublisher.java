package com.blackhuang.mini.spring.context;

import com.blackhuang.mini.spring.context.event.ApplicationEvent;

/**
 * @author blackhuang
 * @date 2024/12/4 11:23
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);

}
