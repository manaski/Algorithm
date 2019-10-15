package com.gangbin.Company.有赞;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/8
 */
public class Main1 {
    public static void getCount(Long N){
        if(N<3){
            System.out.println(0);
            return ;
        }
        int count=0;
        long num=N+1;
        for(int k=2;k<=Math.sqrt(num);k++){
            if((N+1)%k==0){
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            long n=sc.nextLong();
            getCount(n);
        }
    }

}
