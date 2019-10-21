package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/15
 */
public class 轮流取数字的游戏 {//采用动态规划的思想，关键是找到递推关系，对方和自己一样都采取最右的方式来做这件事
    public boolean PredictTheWinner(int[] nums) {
        int len=nums.length;
        int[][]dp=new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=nums[i];
        }
        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                dp[i][j]=Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][len-1]>=0;//可以根据差值找到各自的总和
    }
}
