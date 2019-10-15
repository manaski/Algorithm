package com.gangbin.Others;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/13
 */
public class 是否是回文数 {
    public static boolean isHuiwen(long n){
        if(n<0){
            if(n==Integer.MIN_VALUE){
                return false;
            }else{
                n=-n;
            }
        }
        int len=0;
        long m=n;
        long left=1;
        while(m>0){
            m=m/10;
            len++;
            left=left*10;
        }
        left=left/10;
        int right=10;
        while(left>=right){
            if(n%right!=n/left){
                return false;
            }
            n=n%left/right;
            left=left/100;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean b=isHuiwen(n);
        System.out.println(b);


    }
}
