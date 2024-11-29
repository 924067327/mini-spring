package com.blackhuang.mini.spring.bean;

import lombok.Data;

/**
 * @author blackhuang
 * @date 2024/11/28 17:57
 */
@Data
public class Person {

    private String name;
    private int age;

    private Skill skill;

    public Person() {
    }

    public void desc() {
        System.out.println("test bean " + name + ", age " + age + ", has skill " + skill);
    }
}
