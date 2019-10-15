package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/16
 */
public class 删除重复数字 {
    public static int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                nums[++j]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j+1;
    }

    public static void main(String[] args) {
        int[] a={1,2,1,3,4,4,5,2};
        removeDuplicates(a);
    }
}
