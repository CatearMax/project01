package com.xwc.entity;

/**
 * @author xwc
 * @create 2020-05-07 13:03
 * @name Test
 * @description
 */
public class Test {

    public static void main(String[] args) {
        String a = "^[a-zA-Z0-9，。\\u4E00-\\u9FA5\\s]{2,10}$";
        String b = "鞋子1 。，2ub";
        System.out.println(b.matches(a));
    }
}
