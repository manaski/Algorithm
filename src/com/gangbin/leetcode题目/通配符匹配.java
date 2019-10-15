package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/19
 */
public class 通配符匹配 {
    /**
     * ？ *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(s==null||p==null){
            return false;
        }
        int len1=s.length();
        int len2=p.length();
        char[] c1=s.toCharArray();
        char[] c2=p.toCharArray();
        boolean[][] dp=new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for(int i=1;i<len2;i++){
            if(c2[i]=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }
        for(int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if(c2[j]=='?'||c2[j]==c1[i]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    if(c2[j]=='*'){
                        dp[i][j]=dp[i-1][j]||dp[i][j-1]||dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}
