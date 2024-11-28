package com.blackhuang.mini.spring.bean;

/**
 * @author blackhuang
 * @date 2024/11/28 17:57
 */
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
