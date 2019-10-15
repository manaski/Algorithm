package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class 硬币数 {
    public static int coinChange(int[] coins, int amount) {
        int len=coins.length;
        int[][]dp=new int[len+1][amount+1];
        for(int i=1;i<=amount;i++){
            dp[0][i] = Integer.MAX_VALUE;//不用硬币换钱的硬币数
        }
        for(int i=1;i<=len;i++){
            for(int j=1;j<=amount;j++){
                if(j%coins[i-1]==0){
                    dp[i][j]=j/coins[i-1];
                }
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j]);//不用货币i换钱j
                if(j-coins[i-1]>=0){
                    int m=Math.min(dp[i][j-coins[i-1]],dp[i-1][j-coins[i-1]]);
                    if(m!= Integer.MAX_VALUE){
                        dp[i][j]=Math.min(m+1,dp[i][j]);
                    }
                }
            }
        }
        System.out.println(dp[len][amount]);
        return dp[len][amount];
    }

    public static void main(String[] args) {
        int[] arr={1, 2, 5};
        int a=11;
        coinChange(arr,a);
    }
}
