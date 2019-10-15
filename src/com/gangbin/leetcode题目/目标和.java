package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/29
 */
public class 目标和 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int target=S+sum;
        if((target&1)==1||S>sum){
            return 0;
        }
        target=target/2;//背包问题的目标和    P*2=S+sum
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=target;i>=num;i--){
                dp[i]=dp[i-num]+dp[i]; //逆向循环，避免重复计算，因为计算小的数字时，可能已经用过num了
            }
        }
        return dp[target];
    }
}
