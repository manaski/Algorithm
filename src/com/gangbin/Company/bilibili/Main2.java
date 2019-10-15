package com.gangbin.Company.bilibili;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/10
 */
public class Main2 {
    public static long getMin(long N){
        long res=0;
        if(N==1){
            return 1;
        }
        if(N==2){
            return 1;
        }
        if(N==3){
            return 2;
        }
        for(int i=1;;i++){
            long temp=i*(i-1);
            long mx=N-temp/2;
            if(mx<=0){
                break;
            }
            if(mx%i==0){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        long ret=getMin(N);
        System.out.println(ret);
    }
}
