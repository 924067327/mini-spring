package com.blackhuang.mini.spring.bean;

/**
 * @author blackhuang
 * @date 2024/11/28 17:58
 */
public class Skill {

    private String name;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
