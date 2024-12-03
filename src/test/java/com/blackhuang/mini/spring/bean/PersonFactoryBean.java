package com.blackhuang.mini.spring.bean;

import com.blackhuang.mini.spring.beans.factory.FactoryBean;

/**
 * @author blackhuang
 * @date 2024/12/3 20:48
 */
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() {
        Person person = new Person();
        person.setName("blackhuang—from-factory");
        person.setAge(18);
        person.setSkill(new Skill("Golang"));
        return person;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
