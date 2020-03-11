package com.gangbin.Company.小年糕;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/24
 */
public class Main3 {
    public static int getSubArr(int[] arr){
        int len=arr.length;
        int[]dp=new int[len];
        dp[0]=arr[0];
        int res=dp[0];
        for(int i=1;i<len;i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=arr[i]+max;
            res=Math.max(res,dp[i]);
        }
        System.out.println(res);
        return res;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }
        getSubArr(arr);

    }
}
