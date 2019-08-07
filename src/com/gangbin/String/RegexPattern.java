package com.gangbin.String;
/**
 * 判断含有*.的正则表达式是否可以匹配给定的字符串
 */
public class RegexPattern {
    public static boolean isMatch(String str, String pt){
        if(str==null||str.length()==0||pt==null||pt.length()==0){
            return false;
        }
        int len1=str.length();
        int len2=pt.length();
        char[] chars1=str.toCharArray();
        char[] chars2=pt.toCharArray();
        boolean[][]dp=new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for(int i=0;i<len2;i++){
            dp[0][i+1]=i>0&&chars2[i]=='*'&&dp[0][i-1];
        }

        for(int i=0;i<str.length();i++){
            for(int j=0;j<pt.length();j++){
                //分不同的情况讨论，
                //当为字母，.和*时分别讨论
                if(chars2[j]!='*'&&(chars1[i]==chars2[j]||chars2[j]=='.')){
                    dp[i+1][j+1]=dp[i][j];
                }else  if(chars2[j]=='*'){
                    if(chars2[j-1]!=chars1[i]&&chars2[j-1]!='.'){
                        dp[i+1][j+1]=dp[i+1][j-1];
                    }else{
                        dp[i+1][j+1]=dp[i+1][j-1]||dp[i][j-1]||dp[i][j+1];
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s="abdca";
        String pt=".*dc";
        boolean res=isMatch(s,pt);
        System.out.println(res);
    }


}
