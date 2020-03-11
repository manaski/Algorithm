package com.gangbin.Company.小年糕;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/24
 */
public class Main2 {

    public static String getGC(String s,int n){
        int len=s.length();
        int[][]dp=new int[len][len];
        dp[0][0]=s.charAt(0)=='G'||s.charAt(0)=='C'?1:0;
        for(int i=1;i<len;i++){
            dp[0][i]=s.charAt(i)=='G'||s.charAt(i)=='C'?dp[0][i-1]+1:dp[0][i-1];
        }
        int begin=-1;
        int end=0;
        double maxRatio=0;
        for(int i=1;i<len;i++){
            int num=(s.charAt(i-1)=='G'||s.charAt(i-1)=='C')?-1:0;
            for(int j=i;j<len;j++){
                dp[i][j]=dp[i-1][j]+num;
            }
        }
        for(int i=0;i<len-4;i++){
            for(int j=i+4;j<len;j++){
                double r=(double)dp[i][j]/(j-i+1);
                if(maxRatio<r){
                    begin=i;
                    end=j;
                    maxRatio=r;
                }
            }
        }
        if(begin>=0){
            System.out.println(s.substring(begin,end+1));
            return s.substring(begin,end+1);
        }else{
            System.out.println("");
            return "";
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int n=scanner.nextInt();
        getGC(s,n);

    }
}
