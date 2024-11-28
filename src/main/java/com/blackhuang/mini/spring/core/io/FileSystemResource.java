package com.blackhuang.mini.spring.core.io;

import lombok.AllArgsConstructor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author blackhuang
 * @date 2024/11/28 15:02
 */
@AllArgsConstructor
public class FileSystemResource implements Resource {

    private final String filePath;

    @Override
    public InputStream getInputStream() throws IOException {
        try {
            Path path = Paths.get(filePath);
            return Files.newInputStream(path);
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

}
