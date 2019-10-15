package com.gangbin.leetcode题目;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class 和为k的连续数组 {
    public int subarraySum(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return -1;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        int sum=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<len;i++){
            sum+=nums[i];
           if(map.containsKey(sum-k)){
               count+=map.get(sum-k);
           }
           map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}
