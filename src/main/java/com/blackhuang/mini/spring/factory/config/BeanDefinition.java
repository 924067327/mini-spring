package com.blackhuang.mini.spring.factory.config;

import com.blackhuang.mini.spring.factory.PropertyValues;
import lombok.Data;

/**
 * @author blackhuang
 * @date 2024/11/27 15:07
 */
@Data
public class BeanDefinition {

    private Class<?> beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }
}
