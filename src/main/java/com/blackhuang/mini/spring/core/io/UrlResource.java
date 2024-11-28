package com.blackhuang.mini.spring.core.io;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author blackhuang
 * @date 2024/11/28 15:07
 */
@AllArgsConstructor
public class UrlResource implements Resource {

    private final URL url;

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        return con.getInputStream();
    }
}
