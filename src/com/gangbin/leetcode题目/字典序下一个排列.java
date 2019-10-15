package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 字典序下一个排列 {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int i=nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1]){//注意这里的等于号，找到第一个右边比左边大的值
            i--;
        }
        if(i<0){
            Arrays.sort(nums);
            return;
        }
        int j=nums.length-1;
        while(j>=0&&nums[j]<=nums[i]){ //找到第一个严格大于当前值的值
            j--;
        }
        swap(nums,i,j);
        reverse(nums,i+1,nums.length-1);
    }
    public void reverse(int[] nums, int begin, int end){
        int i=begin;
        int j=end;
        while(i<j){
            swap(nums,i++,j--);
        }
    }
    public void swap(int[] nums, int i, int j){
        nums[i]=nums[j]^nums[i]^(nums[j]=nums[i]);
    }
}
