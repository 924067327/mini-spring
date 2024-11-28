package com.blackhuang.mini.spring.factory.support;

import com.blackhuang.mini.spring.bean.Skill;
import com.blackhuang.mini.spring.bean.Person;
import com.blackhuang.mini.spring.beans.PropertyValue;
import com.blackhuang.mini.spring.beans.PropertyValues;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.beans.factory.config.BeanReference;
import com.blackhuang.mini.spring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

/**
 * @author blackhuang
 * @date 2024/11/27 15:48
 */
class DefaultListableBeanFactoryTest {

    @Test
    public void testGetBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("testBean", new BeanDefinition(Person.class));
        Object bean = beanFactory.getBean("testBean");
        Person person = (Person) bean;
        person.desc();
    }

    @Test
    public void testPopulateProperty() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册bean skill
        PropertyValues skillPvs = new PropertyValues();
        skillPvs.addPropertyValue(new PropertyValue("name", "java"));
        beanFactory.registerBeanDefinition("skill_bean", new BeanDefinition(Skill.class, skillPvs));
        
        // 注册bean test_bean
        PropertyValues personPvs = new PropertyValues();
        personPvs.addPropertyValue(new PropertyValue("name", "blackhuang"));
        personPvs.addPropertyValue(new PropertyValue("age", 30));
        personPvs.addPropertyValue(new PropertyValue("skill", new BeanReference("skill_bean")));
        beanFactory.registerBeanDefinition("person_bean", new BeanDefinition(Person.class, personPvs));
        
        Object bean = beanFactory.getBean("person_bean");
        Person person = (Person) bean;
        person.desc();
    }

}