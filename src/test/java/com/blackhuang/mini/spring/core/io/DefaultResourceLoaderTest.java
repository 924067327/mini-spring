package com.blackhuang.mini.spring.core.io;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author blackhuang
 * @date 2024/11/28 15:15
 */
class DefaultResourceLoaderTest {

    @Test
    void getResource() throws IOException {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource classPathResource = defaultResourceLoader.getResource("classpath:resource_test.properties");
        System.out.println(IoUtil.readUtf8(classPathResource.getInputStream()));

        Resource fileSysResource = defaultResourceLoader.getResource("C:\\Users\\11169169\\java_proj\\mini-spring\\src\\test\\resources\\resource_test.properties");
        System.out.println(IoUtil.readUtf8(fileSysResource.getInputStream()));
    }
}