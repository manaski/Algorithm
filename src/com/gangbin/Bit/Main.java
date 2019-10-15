package com.gangbin.Bit;

import java.util.HashMap;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/11
 */
class Man{
    String name;
    Integer age;
    static String haha;
    public Man(){

    }
    public Man(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public static void getName(){
        System.out.println("父类静态方法");
    }
}

class Child extends Man{
    static String haha;
    public static void getName(){
        System.out.println("子类静态方法");
    }
}

public class Main {
    public static void main(String[] args) {
        HashMap<Man,String> map=new HashMap<>();
//        TreeSet<Man> set=new TreeSet<>();
//        set.add(new Man("523",123));
//        set.add(new Man("224",123));
//        set.add(new Man("223",123));
//        set.add(new Man("324",123));
//        Man man=new Man("man",123);
        Man child=new Child();
        Child.getName();
        Man.getName();




    }
}
