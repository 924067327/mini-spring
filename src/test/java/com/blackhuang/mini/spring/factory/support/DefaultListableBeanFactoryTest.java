package com.blackhuang.mini.spring.factory.support;

import com.blackhuang.mini.spring.factory.PropertyValue;
import com.blackhuang.mini.spring.factory.PropertyValues;
import com.blackhuang.mini.spring.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.factory.config.BeanReference;
import org.junit.jupiter.api.Test;

/**
 * @author blackhuang
 * @date 2024/11/27 15:48
 */
class DefaultListableBeanFactoryTest {

    @Test
    public void testGetBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("testBean", new BeanDefinition(person.class));
        Object bean = beanFactory.getBean("testBean");
        person person = (person) bean;
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
        beanFactory.registerBeanDefinition("person_bean", new BeanDefinition(person.class, personPvs));
        
        Object bean = beanFactory.getBean("person_bean");
        person person = (person) bean;
        person.desc();
    }

    static class person {

        private String name;
        private int age;

        private Skill skill;

        public person() {
        }

        public void desc() {
            System.out.println("test bean " + name + ", age " + age + ", has skill " + skill);
        }
    }

    static class Skill {
        
        private String name;

        public Skill() {
        }

        @Override
        public String toString() {
            return name;
        }
    }

}