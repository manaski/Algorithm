package com.gangbin.Company.拼多多;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/1
 */
public class Main3 {
    public static int getK(int m,int n,int k){
        if(n<m){
            int temp=n;
            n=m;
            m=temp;
        }
        //n>m
        int top=m-1;
        int right=n-1;
        int i=top;//第几行
        int j=right;
        int count=0;
        int res=0;
        int count0=0;
        while(top>=0){
            i=top;
            j=right;
            while(i<=m-1){
                count++;
                if(count>k){
                    break;
                }
                i++;
                j--;
            }
            count0=count;
            top--;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int ret=getK(n,m,k);
        System.out.println(ret);
    }
}
