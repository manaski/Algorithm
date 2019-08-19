package com.gangbin.DynamicPlanning.最长公共子序列;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/20
 */
public class Main {
    public static String getCommon(char[] c1,char[] c2){
        if(c1==null||c2==null||c1.length==0||c2.length==0){
            return "-1";
        }
        int len1=c1.length;
        int len2=c2.length;
        int[][]dp=new int[len1][len2];
        dp[0][0]=c1[0]==c2[0]?1:0;
        for(int i=1;i<len1;i++){
            dp[i][0]=Math.max(dp[i-1][0],c1[i]==c2[0]?1:0);
        }
        for(int i=1;i<len2;i++){
            dp[0][i]=Math.max(dp[0][i-1],c1[0]==c2[i]?1:0);//注意序列的关系
        }

        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(c1[i]==c2[j]){
                    dp[i][j]=Math.max(dp[i-1][j-1]+1,dp[i][j]);
                }
            }
        }
        System.out.println(dp[c1.length-1][c2.length-1]);
        StringBuilder sb=new StringBuilder();
        int i=c1.length-1;
        int j=c2.length-1;
        int index=dp[i][j];
        while(index>0){
            if(i>0&&dp[i][j]==dp[i-1][j]){
                i--;
            }else if(j>0&&dp[i][j]==dp[i][j-1]){
                j--;
            }else{
                sb.append(c1[i]);
                index--;
                i--;
                j--;
            }
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(getCommon(s1.toCharArray(),s2.toCharArray()));

    }
}
