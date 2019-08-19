package com.gangbin.DynamicPlanning.换钱的最少货币数;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 每个面值可以用无数张，和给定钱的面值和数量
 * @date 2019/8/19
 */
public class Main {
    public static int minNum(int[] cash,int aim){
        Arrays.sort(cash);
        if(aim==0){
            return 0;
        }
        if(cash==null||cash.length==0||aim<0||cash[0]>aim){
            return -1;
        }
        int row=cash.length;
        int[] dp=new int[aim+1];

        for(int i=1;i<=aim;i++){
            dp[i]=Integer.MAX_VALUE;
            if(i%cash[0]==0){
                dp[i]=i/cash[0];
            }
        }
      //  System.out.println(Arrays.toString(dp));
        int temp=0;
        for(int i=1;i<cash.length;i++){
           dp[0]=0;
            for(int j=1;j<=aim;j++){
                temp=Integer.MAX_VALUE;
                if(j-cash[i]>=0&&dp[j-cash[i]]!=Integer.MAX_VALUE){
                    temp=dp[j-cash[i]]+1;
                }
                dp[j]=Math.min(dp[j],temp);
            }
        }
        return dp[aim]==Integer.MAX_VALUE?-1:dp[aim];
    }


    public static int getNum2(int[] cash,int aim){
        if(aim==0){
            return 0;
        }
        if(cash==null||cash.length==0||aim<0){
            return -1;
        }
        int[] dp=new int[aim+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        if(cash[0]<=aim){
            dp[cash[0]]=1;
        }

        int temp=0;
        for(int i=1;i<cash.length;i++){
            dp[0]=0;
            for(int j=aim;j>=1;j--){
                temp=Integer.MAX_VALUE;
                if(j-cash[i]>=0&&dp[j-cash[i]]!=Integer.MAX_VALUE){
                    temp=dp[j-cash[i]]+1;
                }
                dp[j]=Math.min(dp[j],temp);
            }
        }
        return dp[aim]==Integer.MAX_VALUE?-1:dp[aim];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int aim=scanner.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int re=minNum(arr,aim);
       int ret=getNum2(arr,aim);
        System.out.println(re);
        System.out.println(ret);
    }

}
