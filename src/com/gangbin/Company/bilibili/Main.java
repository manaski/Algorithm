package com.gangbin.Company.bilibili;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/10
 */
public class Main {
    public static int getMinOp(String str1,String str2){
        if(str1==null||str2==null){
            return 0;
        }
        char[] c1=str1.toCharArray();
        char[] c2=str2.toCharArray();
        if(str1.length()==0||str2.length()==0){
            return str1.length()==0?str2.length():str1.length();
        }
        int len1=str1.length();
        int len2=str2.length();
        int[][]dp=new int[len1+1][len2+1];
        dp[0][0]=0;
        for(int i=1;i<=len1;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=len2;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                int min=Math.min(dp[i-1][j],dp[i][j-1]);
                min=Math.min(min,dp[i-1][j-1]);
                dp[i][j]=min+1;
                if(c1[i-1]==c2[j-1]){
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i][j]);
                 }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        int ret=getMinOp(str1,str2);
        System.out.println(ret);
    }
}
