package com.gangbin.Other.整数的次方;

/**
 * @author gangbin.li
 * @description: 整数的整数的次方,时间复杂度O(logn)
 * @date 2019/8/19
 */
public class Main {
    public static int multi(int n,int m){
        if(n==0){
            return 0;
        }
        if(m==0){
            return 1;
        }
        int mul=n;
        int res=1;

        while(m>0){
            if((1&m)!=0){
                res*=mul;
            }
            mul*=mul;
            m>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        int res=multi(10,3);
        System.out.println(res);
    }
}
