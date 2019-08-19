package com.gangbin.Company.腾讯;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description:   爬塔的游戏
 * @date 2019/8/14
 */
public class BlackAndWhite {
    public static void main(String[] args) {
        // 构建p和t数组存储最短时间
        int []p=new int[10005];
        int []t=new int[10005];
        Scanner sc=new Scanner(System.in);
        // 塔的高度为层
        int n=sc.nextInt();
        // 构建塔数组
        int []a=new int[n];
        int count=0;
        while (count<n){
            a[count++]=sc.nextInt();
        }
        // i代表第几层 a[i-1]代表从上一层到现在层的高度
        for (int i=1;i<=n;i++){
            // 第i层是爬上来的
            p[i]=Math.min(p[i-1],t[i-1])+a[i-1];
            // 第i层是跳上来的
            if (i>=2)
                t[i]=Math.min(p[i-1],p[i-2]);
        }
        System.out.println(Math.min(p[n],t[n]));
    }
}
