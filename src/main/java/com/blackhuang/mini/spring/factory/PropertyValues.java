package com.blackhuang.mini.spring.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blackhuang
 * @date 2024/11/28 10:50
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValues.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue propertyValue : propertyValues) {
            if (propertyValue.getName().equals(name)) {
                return propertyValue;
            }
        }
        return null;
    }

}
