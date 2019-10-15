package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
//从左向右找到要调整的右边界，也就是不满足大小关系的右边界
    //从右向左遍历找到不满足关系的左边界，这两者之间就是全都需要调整的
public class 最短无序连续数组 {
    public int findUnsortedSubarray(int[] nums) {
        int min=nums[nums.length-1];
        int max=nums[0];
        int start=-1;
        int end=-2;
        for(int i=0,j=nums.length-1;i<nums.length;i++,j=nums.length-1-i){
            min=Math.min(min,nums[j]);
            max=Math.max(max,nums[i]);
            if(nums[i]<max){
                end=i;
            }
            if(nums[j]>min){
                start=j;
            }

        }
        return end-start+1;
    }

}
