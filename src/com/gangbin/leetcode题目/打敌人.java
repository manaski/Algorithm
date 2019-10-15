package com.gangbin.leetcode题目;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/29
 */
public class 打敌人 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int count=0;
        for(int i=0;i<n;i++){
            int index=i+1;
            if(index*2+1<=n&&arr[index-1]!=0){
                arr[2*index-1]-=arr[index-1];
                arr[2*index]-=arr[index-1];
                count+=arr[index-1];
                arr[index-1]=0;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                count+=arr[i];
            }
        }
        System.out.println(count);
    }
}
