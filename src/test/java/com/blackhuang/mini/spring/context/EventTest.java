package com.blackhuang.mini.spring.context;

import com.blackhuang.mini.spring.bean.Person;
import com.blackhuang.mini.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.Test;

/**
 * @author blackhuang
 * @date 2024/12/4 11:52
 */
public class EventTest {
    
    @Test
    public void test() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:xml_test.xml");
        context.registerShutdownHook();

        Person p = context.getBean("blackhuang", Person.class);
        p.desc();
    }
    
}
