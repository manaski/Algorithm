package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/21
 */
public class 两个数组的距离 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt=0;
        int j=0;
        for(int i=0;i<arr1.length;i++){
            j=0;
            for(;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j])>=d){
                    break;
                }
            }
            if(j==arr2.length){
                cnt++;
            }
        }
        return cnt;

    }
}
