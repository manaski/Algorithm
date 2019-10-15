package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
public class 分割数组相等 {
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if((sum&1)==1){
            return false;
        }
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int num:nums){
            for(int j=target;j>=num;j--){
                dp[j]=dp[j]||dp[j-num];
            }
        }
        return dp[target];
    }
}
