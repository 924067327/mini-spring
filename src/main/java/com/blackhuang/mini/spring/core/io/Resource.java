package com.blackhuang.mini.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author blackhuang
 * @date 2024/11/28 15:01
 */
public interface Resource {
    
    InputStream getInputStream() throws IOException;
    
}
