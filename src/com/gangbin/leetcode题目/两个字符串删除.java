package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/25
 */
public class 两个字符串删除 {
    public int minDistance(String word1, String word2) {
        if(word1==null||word2==null){
            return 0;
        }
        if(word1.length()==0){
            return word2.length();
        }
        if(word2.length()==0){
            return word1.length();
        }
        char[] chars1=word1.toCharArray();
        char[] chars2=word2.toCharArray();
        int len1=word1.length();
        int len2=word2.length();
        int[][]dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                dp[i][j]=0;
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
            }
        }
        return len1+len2-2*dp[len1][len2];
    }
}
