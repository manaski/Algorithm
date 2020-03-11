package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/11/3
 */
public class 优美子数组 {
    public static int numberOfSubarrays(int[] nums, int k) {
        int size=0;
        int count=0;
        if(nums==null||nums.length<k){
            return 0;
        }
        int i=0;
        int j=0;
        int left=0;
        int right=0;
        while(j<nums.length){
            if(nums[j]%2==1){
                size++;
            }
            while(i<nums.length&&size>k){
                if(nums[i]%2==1){
                    size--;
                }
                i++;
            }
            if(size==k){
                left=1;
                right=1;
               while(j+1<nums.length&&nums[j+1]%2!=1){
                   j++;
                   right++;
               }
               while(i<nums.length&&nums[i]%2!=1){
                   i++;
                   left++;
               }
               count+=left*right;
            }
            j++;
        }

        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] arr={2,4,6};
        numberOfSubarrays(arr,1);
    }
}
