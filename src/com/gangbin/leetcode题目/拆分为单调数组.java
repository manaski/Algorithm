package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/2
 */
public class 拆分为单调数组 {
    public static boolean canDivideIntoSubsequences(int[] nums, int K) {
        int len=nums.length;
        int max=1;
        int index=0;
        int count=1;
        while (index<len){
            if(index<len-1){
                if(nums[index]==nums[index+1]){
                    count++;
                    max=Math.max(max,count);
                }else{
                    count=1;
                }
            }
            index++;
        }
        if(max*K>len){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,3,4,4};
        canDivideIntoSubsequences(arr,3);
    }
}
