package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/28
 */
public class 其他元素乘积 {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] left=new int[len];
        int[] right=new int[len];
        left[0]=nums[0];
        right[len-1]=nums[len-1];
        for(int i=1;i<len;i++){
            left[i]=left[i-1]*nums[i];
            right[len-1-i]=right[len-i]*nums[len-i-1];
        }
        int[] res=new int[len];
        for(int i=1;i<len-1;i++){
            res[i]=left[i-1]*right[i+1];
        }
        res[0]=right[1];
        res[len-1]=left[len-2];
        return res;

    }
}
