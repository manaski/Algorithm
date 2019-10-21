package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/17
 */
public class 三个递增子序列 {
    public static boolean increasingTriplet(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(process(nums,i,1)){
                return true;
            }
        }
        return false;
    }
    public static boolean process(int[] nums, int index, int count){
        if(count>=3){
            return true;
        }
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]>nums[index]){
                if(process(nums, i, count+1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(list.get(len-1)<nums[i]){
                list.add(nums[i]);
                len++;
            }else{
                int j=len-1;
                while(j>0&&list.get(j)>nums[i]){
                    j--;
                }
                list.set(j,nums[i]);
            }
            if(len>=3){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,-10,-8,-7};
        increasingTriplet(arr);
    }
}
