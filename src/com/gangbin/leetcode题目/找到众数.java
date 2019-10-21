package com.gangbin.leetcode题目;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/20
 */
public class 找到众数 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> count=new HashMap<>();
        int len=nums.length;
        for(int i=0;i<len;i++){
            int n=count.getOrDefault(nums[i],0);
            count.put(nums[i],n+1);
            if(n+1>=len/2){
                return nums[i];
            }
        }
        return 0;
    }
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
