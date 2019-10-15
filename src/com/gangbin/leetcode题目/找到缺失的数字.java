package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/17
 */
public class 找到缺失的数字 {
    public static int find(int[] nums){
        int i=-1;
        int j=0;
        int len=nums.length-1;
        nums[len]=-1;
        int index=-1;
         for(;j<nums.length;j++){
             while(nums[j]!=j&&nums[j]!=-1){
                 int p=nums[j];
                 int p1=nums[p];
                 nums[p]=p;
                 nums[j]=p1;
                 if(p1==-1){
                     index=j;
                 }
             }
                 i++;
                 j++;
         }
        System.out.println(index);
         return index;
    }

    public static void main(String[] args) {
        int[] a={2,0,5,1,3,0};
        find(a);
    }
}
