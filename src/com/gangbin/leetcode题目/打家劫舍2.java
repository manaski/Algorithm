package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/29
 */
public class 打家劫舍2 {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length;
        int[] dp=new int[len];
        if(len<2){
            return nums[0];
        }
        if(len<3){
            return Math.max(nums[0],nums[1]);
        }
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],dp[1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }
    public int rob2(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length;
        int[] dp=new int[len-1];
        if(len<2){
            return nums[0];
        }
        if(len<3){
            return Math.max(nums[0],nums[1]);
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<len-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int[] dp2=new int[len-1];
        dp2[0]=nums[1];
        dp2[1]=Math.max(nums[2],nums[1]);
        for(int i=2;i<len-1;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i+1]);
        }
        return Math.max(dp[len-2],dp2[len-2]);
    }
}
