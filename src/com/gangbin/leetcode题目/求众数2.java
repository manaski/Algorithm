package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/20
 */
public class 求众数2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }
        int a=nums[0];
        int b=2;
        for(Integer t:nums){
            if(t!=a){
                b=t;
                break;
            }
        }
        int counta=0;
        int countb=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==a){
                counta++;
            }else if(nums[i]==b){
                countb++;
            }else{
                counta--;
                countb--;
                if(counta==0){
                    a=nums[i];
                    counta=1;
                }else if(countb==0){
                    b=nums[i];
                    countb=1;
                }
            }

        }
        counta=0;
        countb=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==a){
                counta++;
            }
            if(nums[i]==b){
                countb++;
            }
        }
        if(counta>nums.length/3){
            res.add(a);
        }
        if(b!=a&&countb>nums.length/3){
            res.add(b);
        }

        return res;
    }
}
