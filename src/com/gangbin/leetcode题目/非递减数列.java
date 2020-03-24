package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/18
 */
public class 非递减数列 {
    public boolean checkPossibility(int[] nums) {
        int cnt=0;
        int index=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                cnt++;
                index=i-1;
            }
            if(cnt>1){
                return false;
            }
        }
        if(cnt==0){
            return true;
        }
        int pre=index-1;
        int A=index;
        int B=index+1;
        int pos=index+2;
        if(pre<0||pos>=nums.length){
            return true;
        }
        return nums[pre]<=nums[B]&&nums[B]<=nums[pos]
                ||nums[pre]<=nums[A]&&nums[A]<=nums[pos];

    }
}
