package com.gangbin.Company.拼多多2019;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/25
 */
public class Main4 {

    static int a;
    static int b;
    int c;
    protected Main4(){
        c=1;
    }
    public void fun(){
        int b;
        System.out.println(c);
    }
    public static void fun1(){
        final int aa;
        class A{
            int mm;
        }

        System.out.println(a);
        A ba=new A();
        System.out.println(ba);
    }
    private class Inner{
        int d=a;
        String name;
    }
    static class Inner2{
        String name;
    }



    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        long n=scanner.nextLong();
//        long m=scanner.nextLong();
//        long k= scanner.nextLong();
        System.out.println(a);
        Main4 main4 = new Main4();
        System.out.println(main4.c);
        main4.fun();
        Inner a=main4.new Inner();
        Inner2 b=new Main4.Inner2();
        Main4.fun1();

    }
}
