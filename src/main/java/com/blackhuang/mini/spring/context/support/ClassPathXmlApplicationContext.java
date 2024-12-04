package com.blackhuang.mini.spring.context.support;

import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.context.event.ApplicationEvent;

/**
 * @author blackhuang
 * @date 2024/11/29 16:51
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {


    private final String[] configLocations;

    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }
    
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }
    
    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
    
}
