package com.gangbin.Company.网易;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class Main2 {
    public static void fun(int A,int B, int p, int q){
        if(A>=B){
            System.out.println(0);
            return;
        }
        int count=getTime(A,B,p);
        for(int i=1;i<count;i++){
            int temp=i;
            p=p*q;
            temp+=getTime(A,B,p);
            if(temp<count){
                count=temp;
            }else{
                break;
            }
        }
        System.out.println(count);
    }
    public static int getTime(int A, int B, int p){
        int d=B-A;
        int n=d/p;
        if(d%p!=0){
            n=n+1;
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        for(int i=0;i<T;i++){
        int A=sc.nextInt();
        int B=sc.nextInt();
        int p=sc.nextInt();
        int q=sc.nextInt();
            fun(A,B,p,q);
        }
    }
}
