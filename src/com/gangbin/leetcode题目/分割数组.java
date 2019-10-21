package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/15
 */
public class 分割数组 {
    public static int splitArray(int[] nums, int m) {
        int begin=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>begin){
                begin=nums[i];
            }
            end+=nums[i];
        }

        int mid=0;
        while(begin<=end){
            mid=begin+(end-begin)/2;
            int res=checkNum(mid,nums);
            if(res>m){
                begin=mid+1;
            }else{
                end=mid-1;
            }
        }
        return begin;
    }
    public static int checkNum(int num,int[] nums){
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>num){
                count++;
                sum=nums[i];
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        int[]nums={1,2147483646};
        splitArray(nums,1);

    }
}
