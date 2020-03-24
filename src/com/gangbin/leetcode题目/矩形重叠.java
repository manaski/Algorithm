package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/18
 */
public class 矩形重叠 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[2]<=rec2[0]||rec1[0]>=rec2[2]
        ||rec1[1]>=rec2[3]||rec1[3]<=rec2[1]){
            return false;
        }
        return true;

    }
}
