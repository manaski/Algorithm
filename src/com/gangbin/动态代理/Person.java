package com.gangbin.动态代理;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/11
 */
public class Person implements Human{
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void dance() {
        System.out.println(name+"person dancing");
    }

    @Override
    public void sing(String song) {
        System.out.println(name+" is sing a song "+song);
    }
}
