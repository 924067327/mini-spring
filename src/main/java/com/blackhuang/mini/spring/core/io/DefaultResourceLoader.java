package com.blackhuang.mini.spring.core.io;

/**
 * @author blackhuang
 * @date 2024/11/28 15:09
 */
public class DefaultResourceLoader implements ResourceLoader {

    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            return new FileSystemResource(location);
        }
    }
}
