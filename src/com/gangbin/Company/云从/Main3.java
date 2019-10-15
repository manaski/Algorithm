package com.gangbin.Company.云从;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class Main3 {
    public static int getCoins(int[] coins, int sum){
        int len1=coins.length;
        int[][]dp=new int[len1][sum+1];
        for(int i=1;i<=sum;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<len1;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i]]+1);
                }
            }
        }
        int res=dp[len1-1][sum]==Integer.MAX_VALUE?-1:dp[len1-1][sum];
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        if(s1.length()<=2){
            System.out.println(-1);
            return;
        }
        s1=s1.substring(1,s1.length()-1);
        String[]ss1=s1.split(", ");
        int[] coins=new int[ss1.length];
        for(int i=0;i<coins.length;i++){
            coins[i]=Integer.valueOf(ss1[i]);
        }
        int sum=Integer.valueOf(s2);
        if(sum<0){
            System.out.println(-1);
            return;
        }
        getCoins(coins,sum);
    }
}
