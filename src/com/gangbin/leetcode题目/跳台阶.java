package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
public class 跳台阶 {
    public static boolean canJump(int[] nums) {
        int cur=0;
        int next=-1;
        for(int i=0;i<nums.length;i++){
            if(i>cur){
                if(next<i){
                    return false;
                }
                cur=next;
                if(cur>=nums.length-1){
                    return true;
                }
            }
            next=Math.max(next,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a={0,1,1,2};
        canJump(a);
    }
}
