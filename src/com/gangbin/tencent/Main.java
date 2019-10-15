package com.gangbin.tencent;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/19
 */
public class Main {
    public boolean isMatch(String s, String p) {
        if(p==null||p.equals("")){
            return false;
        }
        if(s==null||s.equals("")){
            return false;
        }
        int len1=s.length();
        int len2=p.length();
        //. *
        boolean[][]dp=new boolean[len1+1][len2+1];
        dp[0][0]=true;
        char[] c1=s.toCharArray();
        char[] c2=p.toCharArray();
        for(int i=2;i<=len2;i++){
            if(c2[i-1]=='*'&&dp[0][i-2]){
                dp[0][i]=true;
            }
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<len2;j++){
                if(c2[j-1]=='.'||c1[i-1]==c2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else if(c2[j-1]=='*'){
                    if(c2[j-2]=='.'||c2[j-2]==c1[i-1]){
                        dp[i][j]=dp[i-1][j-2]||dp[i][j-2]||dp[i-1][j];
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {

    }
}
