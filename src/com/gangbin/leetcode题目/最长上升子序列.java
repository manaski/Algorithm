package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
         int max=0;
         int[]dp=new int[nums.length];
         dp[0]=1;
         for(int i=0;i<nums.length;i++){
             int maxV=0;
           for(int j=i-1;j>=0;j--){
               if(nums[j]<nums[i]){
                   maxV=Math.max(maxV,dp[j]);
               }
           }
           dp[i]=maxV+1;
           max=Math.max(max,dp[i]);
         }
         return max;
    }
}
