package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == '1'){//只处理当前值为1的情况
                    //应该考虑的是三个位置的正方形的边长值，选最小的那个，那么只要加1就是新的边长
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
