package com.gangbin.String;

/**
 * 求最小的切割次数，把字符串切割成回文子串
 */
public class MinCutForPallination {
    public static int minCut(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        char[] chars=str.toCharArray();
        int len=chars.length;
        int[] dp=new int[len+1];//这里多写一位
        dp[len]=-1;             //最后一位为-1
        boolean[][]p=new boolean[len][len];
        for(int i=len-1;i>=0;i--){      //从右往左进行遍历。从左向右也可以
            dp[i]=Integer.MAX_VALUE;
            for(int j=i;j<len;j++){
                if(chars[i]==chars[j]&&(j-i<2||p[i+1][j-1])){
                    p[i][j]=true;      //更新p
                    dp[i]=Math.min(dp[i],dp[j+1]+1);//更新dp
                }
            }
        }
        return dp[0];
    }


}
