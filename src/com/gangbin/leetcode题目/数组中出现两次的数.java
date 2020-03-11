package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gangbin.li
 * @description: 这道题有很多做法
 * @date 2019/11/7
 */
public class 数组中出现两次的数 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i]);
            if(nums[num-1]<0){
                res.add(num);
            }else{
                nums[num-1]*=-1;
            }
        }
        return res;
    }
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int index=(nums[i]-1)%n;
            nums[index]+=n;
        }
        for(int i=0;i<n;i++){
            if(nums[i]>2*n){
                res.add(i+1);
            }
        }
        return res;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        Set<Integer> ress=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]!=i+1){
                if(nums[nums[i]-1]==nums[i]){
                    ress.add(nums[i]);
                    break;
                }
                swap(nums,i,nums[i]-1);
            }
        }
        List<Integer> res=new ArrayList<>(ress);
        return res;
    }
    public static void swap(int[] nums, int i, int j){
        nums[i]=nums[j]^(nums[j]=nums[i])^nums[i];
    }

    public static void main(String[] args) {
        int[] nums={3,3,3,3,3,3,3};
        findDuplicates2(nums);
    }

}
