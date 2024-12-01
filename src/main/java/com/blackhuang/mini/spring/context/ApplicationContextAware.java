package com.blackhuang.mini.spring.context;

import com.blackhuang.mini.spring.beans.Aware;
import com.blackhuang.mini.spring.beans.BeansException;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
