package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/16
 */
public class 全排列 {
    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        process(res,nums,0);
        System.out.println(res);
        return res;
    }
    public static void process(List<List<Integer>> res,int[] nums,int index){
        int i=index;
        if(index==nums.length){
            ArrayList<Integer> list=new ArrayList<>();
            for(Integer t:nums){
                list.add(t);
            }
            res.add(list);
            return;
        }
        for(;i<nums.length;i++){
           swap(nums,index,i);
           process(res,nums,index+1);
           swap(nums,index,i);
        }
    }
    public static void swap(int[] arr, int i, int j){
        arr[i]=arr[j]^arr[i]^(arr[j]=arr[i]);
    }

    public static void main(String[] args) {
        int[] arr={2,1,3};
        Arrays.sort(arr);
        permute(arr);
    }
}
