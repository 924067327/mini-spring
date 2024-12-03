package com.blackhuang.mini.spring.factory.support;

import com.blackhuang.mini.spring.bean.Person;
import com.blackhuang.mini.spring.context.ConfigurableApplicationContext;
import com.blackhuang.mini.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

/**
 * @author blackhuang
 * @date 2024/12/3 20:51
 */
public class FactoryBeanTest {

    @Test
    public void test() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:xml_test.xml");
        context.registerShutdownHook();

        Person p = context.getBean("black_huang_from_factory_bean", Person.class);
        p.desc();
    }

}
