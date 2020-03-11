package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/29
 */
public class 最长的1的序列 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen=0;
        int zeros=0;
        int left=0;
        int right=0;
        while(right<nums.length){
            if(nums[right]==0){
                zeros++;
            }
            while(zeros>1){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxLen=0;
        int i=0;
        int len=0;
        while(i<nums.length){
            if(nums[i]==0){
                len=0;
                i++;
                continue;
            }
            while(i<nums.length&&nums[i]==1){
                i++;
                len++;
            }
            maxLen=Math.max(maxLen,len);
        }

        return maxLen;
    }
    public int longestOnes(int[] A, int K) {
        int maxLen=0;
        int zeros=0;
        int left=0;
        int right=0;
        while(right<A.length){
            if(A[right]==0){
                zeros++;
            }
            while(zeros>K){
                if(A[left]==0){
                    zeros--;
                }
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;

    }
}
