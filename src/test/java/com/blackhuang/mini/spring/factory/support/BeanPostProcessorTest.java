package com.blackhuang.mini.spring.factory.support;

import com.blackhuang.mini.spring.bean.MyBeanPostProcessor;
import com.blackhuang.mini.spring.bean.Person;
import com.blackhuang.mini.spring.beans.factory.support.DefaultListableBeanFactory;
import com.blackhuang.mini.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.jupiter.api.Test;

/**
 * @author blackhuang
 * @date 2024/11/28 21:18
 */
public class BeanPostProcessorTest {

    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:xml_test.xml");

        Person p = (Person) beanFactory.getBean("blackhuang");

        p.desc();

    }

}
