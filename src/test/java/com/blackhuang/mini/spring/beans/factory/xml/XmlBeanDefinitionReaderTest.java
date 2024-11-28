package com.blackhuang.mini.spring.beans.factory.xml;

import com.blackhuang.mini.spring.bean.Person;
import com.blackhuang.mini.spring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

/**
 * @author blackhuang
 * @date 2024/11/28 19:47
 */
class XmlBeanDefinitionReaderTest {

    @Test
    public void testLoadBeanDefinition() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:xml_test.xml");

        Object bean = beanFactory.getBean("person");
        ((Person) bean).desc();
    }

}