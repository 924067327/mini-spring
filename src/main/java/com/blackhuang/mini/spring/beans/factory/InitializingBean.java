package com.blackhuang.mini.spring.beans.factory;

public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}
