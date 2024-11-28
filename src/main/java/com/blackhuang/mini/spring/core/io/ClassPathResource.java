package com.blackhuang.mini.spring.core.io;

import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author blackhuang
 * @date 2024/11/28 15:10
 */
@AllArgsConstructor
public class ClassPathResource implements Resource {

    private final String path;

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
        if (Objects.isNull(is)) {
            throw new FileNotFoundException( " class path (" + path + ") does not exist");
        }
        return is;
    }
}
