package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/24
 */
public class 按摩师预约 {
    public static int massage(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int len=nums.length;
        int[]dp=new int[len];
        if(len<2){
            return nums[0];
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        int[] nums={2,1,4,5,3,1,1,3};
        int res=massage(nums);
        System.out.println(res);
    }
}
