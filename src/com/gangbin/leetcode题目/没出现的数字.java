package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 因为如果数字全都存在的话，数字的值和下标具有一一对应的关系，
 * 因此，可以根据出现的数字对对应下标的数字进行一些操作，最后再检查一遍
 * @date 2019/9/28
 */
public class 没出现的数字 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len;i++){
            int index=(nums[i]-1)%len;
            nums[index]+=len;
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<len;i++){
            if(nums[i]<=len){
                res.add(i+1);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        findDisappearedNumbers(arr);
    }
}
