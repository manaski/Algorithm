package com.gangbin.Company.网易;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class Main1 {
    public static void fun(int x){
        if(x<10){
            System.out.println(x);
            return;
        }
        String s="";
        while(x>=10){
            s="9"+s;
            x=x-9;
        }
        if(x!=0){
            s=String.valueOf(x)+s;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int x=sc.nextInt();
            fun(x);
        }
    }

}
