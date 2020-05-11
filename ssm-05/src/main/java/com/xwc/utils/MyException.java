package com.xwc.utils;

/**
 * @author xwc
 * @create 2020-04-18 17:17
 * @name MyException
 * @description 自定义异常
 */
public class MyException extends Exception {

    /**
     * 构造方法
     * @param message
     */
    public MyException(String message) {
        super(message);
    }
}
