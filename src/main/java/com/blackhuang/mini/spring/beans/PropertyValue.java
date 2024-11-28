package com.blackhuang.mini.spring.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author blackhuang
 * @date 2024/11/28 10:49
 */
@Data
@AllArgsConstructor
public class PropertyValue {
    
    private String name;
    private Object value;
    
}
