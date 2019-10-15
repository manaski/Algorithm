package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 乘积最大的连续子序列 {
    public int maxProduct(int[] nums) {
         int min1=1;
         int max1=1;
         int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                min1=max1^min1^(max1=min1);//当前值为负数时，交换最大最小值
            }
            min1=Math.min(min1*nums[i],nums[i]);//最小值是当前值，当前值乘以前面的最小值中比较小的一个
            //保证了后面计算时，肯定包含了nums[i]这个值，所以肯定是连续序列
            max1=Math.max(max1*nums[i],nums[i]);
            max=Math.max(max1,max);
        }
        return max;
    }
}
