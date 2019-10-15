package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 记住这个解题方式 dp[i][j]表示以0-i的数字组成的序列以j结尾的方法数，根据i-1的要求不同，会有不同的递推方式
 * @date 2019/9/30
 */
public class DI排列的可能数 {
    public int numPermsDISequence(String S) {
        if(S==null||S.length()==0){
            return 0;
        }
        int res = 0;
        int n = S.length();
        int M = 1000000007;
        int[][] dp=new int[n+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (S.charAt(i-1) == 'D') {
                    for (int k = j; k <= i - 1; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % M;
                    }
                } else {
                    for (int k = 0; k <= j - 1; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % M;
                    }
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            res = (res + dp[n][i]) % M;
        }
        return res;
    }
}
