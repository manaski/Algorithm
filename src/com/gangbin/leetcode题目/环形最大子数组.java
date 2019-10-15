package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class 环形最大子数组 {
    public static int maxSubarraySumCircular(int[] A) {
        int[] arr=A;
        int max=0;
        int sum=0;
        int sum2=0;
        int min= Integer.MAX_VALUE;
        int total=0;
        for(int i=0;i<arr.length;i++){
            total+=arr[i];
          sum=Math.max(arr[i],arr[i]+sum);
          max=Math.max(sum,max);
          sum2=Math.min(arr[i],arr[i]+sum2);
          min=Math.min(min,sum2);
        }
        System.out.println(max);
        System.out.println(min);
        return Math.max(max,total-min);
    }

    public static void main(String[] args) {
        int[] arr={1,2,-3,3,-7};
        maxSubarraySumCircular(arr);
    }
}
