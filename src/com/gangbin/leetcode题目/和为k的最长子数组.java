package com.gangbin.leetcode题目;

import java.util.HashMap;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/22
 */
public class 和为k的最长子数组 {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                max=Math.max(max,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return max;
    }
}
