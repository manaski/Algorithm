package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int len=1;
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]-1){
                len++;
                max=Math.max(max,len);
            }else{
                if(nums[i]!=nums[i+1]){
                    len=0;
                }
            }
        }
        return max;
    }
}
