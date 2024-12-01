package com.blackhuang.mini.spring.bean;

import com.blackhuang.mini.spring.beans.factory.DisposableBean;
import com.blackhuang.mini.spring.beans.factory.InitializingBean;
import lombok.Data;

/**
 * @author blackhuang
 * @date 2024/11/28 17:57
 */
@Data
public class Person implements InitializingBean, DisposableBean {

    private String name;
    private int age;

    private Skill skill;

    public Person() {
    }

    public void desc() {
        System.out.println("test bean " + name + ", age " + age + ", has skill " + skill);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitializingBean.destroy-method " + name);
    }

    public void initWithXml() {
        System.out.println("xml.init-method " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DisposableBean.afterPropertiesSet-method " + name);
    }

    public void destroyWithXml() {
        System.out.println("xml.destroyMethod-method " + name);
    }
}
