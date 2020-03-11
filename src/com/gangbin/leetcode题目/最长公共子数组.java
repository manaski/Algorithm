package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/22
 */
public class 最长公共子数组 {
    public int findLength(int[] A, int[] B) {
        int len1=A.length;
        int len2=B.length;
        int[][]dp=new int[len1+1][len2+1];
        int max=0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                dp[i][j]=A[i]==B[j]?dp[i-1][j-1]+1:0;
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
