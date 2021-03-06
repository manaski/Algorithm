package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 可以想到递归遍历，应该可以想到记忆化遍历，想到动态规划
 * @date 2019/10/2
 */
public class 播放列表数量 {
    public int numMusicPlaylists(int N, int L, int K) {
        long[][]dp=new long[L+1][N+1];
        dp[0][0]=1;
        for(int i=1;i<L;i++){
            for(int j=1;j<=N;j++){
                dp[i][j]=dp[i-1][j-1]*(N-j+1);
                dp[i][j]=dp[i-1][j]*Math.min(j-K,0);
                dp[i][j]=dp[i][j]%1000000007;
            }
        }
        return (int) dp[L][N];
    }
}
