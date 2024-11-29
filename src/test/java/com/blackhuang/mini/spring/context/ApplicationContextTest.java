package com.blackhuang.mini.spring.context;

import com.blackhuang.mini.spring.bean.Person;
import com.blackhuang.mini.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

/**
 * @author blackhuang
 * @date 2024/11/29 17:17
 */
class ApplicationContextTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:xml_test.xml");
        Person p = context.getBean("blackhuang", Person.class);
        p.desc();
    }

}