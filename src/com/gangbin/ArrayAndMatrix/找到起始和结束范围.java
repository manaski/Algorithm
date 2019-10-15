package com.gangbin.ArrayAndMatrix;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
public class 找到起始和结束范围 {
    public static int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        int leftMerge=low;
        low=0;
        high=nums.length-1;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        int rightMerge=high;
        if(leftMerge>=0&&leftMerge<nums.length&&nums[leftMerge]==target){
            return new int[]{leftMerge,rightMerge};
        }else{
            return new int[]{-1,-1};
        }
    }

    public static void main(String[] args) {
        int[] a={2,2};
        searchRange(a,3);
    }
}
