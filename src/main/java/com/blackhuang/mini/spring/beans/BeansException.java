package com.blackhuang.mini.spring.beans;

/**
 * @author blackhuang
 * @date 2024/11/27 14:58
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(Throwable cause) {
        super(cause);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
