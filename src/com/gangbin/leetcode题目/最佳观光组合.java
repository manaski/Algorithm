package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/23
 */
public class 最佳观光组合 {
    public int maxScoreSightseeingPair(int[] A) {
        int maxPair=0;
        int preMax=A[0]+0;

        for(int i=1;i<A.length;i++){
            int temp=A[i]-i+preMax;
            maxPair=Math.max(maxPair,temp);
            preMax=Math.max(preMax,A[i]+i);
        }
        return maxPair;
    }
}
