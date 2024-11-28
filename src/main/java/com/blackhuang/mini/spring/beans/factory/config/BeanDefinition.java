package com.blackhuang.mini.spring.beans.factory.config;

import com.blackhuang.mini.spring.beans.PropertyValues;
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
        this(beanClass, new PropertyValues());
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }
}
