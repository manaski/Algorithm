package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/28
 */
public class 移动0 {
    public static void moveZeroes1(int[] nums) {
        int len=nums.length;
        int i=len-1;
        while(i>=0){
            if(nums[i]==0){
                int j=i;
                while(j<len-1&&nums[j+1]!=0){
                    nums[j]=nums[j+1];
                    j++;
                }
                nums[j]=0;
            }
            i--;
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int len=nums.length;
        int i=0;
        int j=0;
        while(j<len){
            if(nums[j]!=0){
                swap(nums,i,j);
                i++;
            }

            j++;
        }
        while(i<len){
            nums[i++]=0;
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void swap(int[] nums, int i, int j){
        nums[i]=nums[j]^nums[i]^(nums[j]=nums[i]);
    }

    public static void main(String[] args) {
        int[] nums={0,2,0,3,5,1};
        moveZeroes(nums);
    }
}
