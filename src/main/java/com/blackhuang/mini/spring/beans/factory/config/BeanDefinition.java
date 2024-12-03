package com.blackhuang.mini.spring.beans.factory.config;

import com.blackhuang.mini.spring.beans.PropertyValues;
import lombok.Data;

/**
 * @author blackhuang
 * @date 2024/11/27 15:07
 */
@Data
public class BeanDefinition {

    public static final String SCOPE_SINGLETON = "singleton";

    public static final String SCOPE_PROTOTYPE = "prototype";
    
    private Class<?> beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    private String scope = SCOPE_SINGLETON;
    
    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, new PropertyValues());
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }
    
    public boolean isSingleton() {
        return SCOPE_SINGLETON.equals(scope);
    }
    
    public boolean isPrototype() {
        return SCOPE_PROTOTYPE.equals(scope);
    }
    
}
