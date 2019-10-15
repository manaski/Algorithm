package com.gangbin.Company.同城58;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/12
 */
public class Main3 {
//    public static int findPath(){
//
//
//    }
    public static int findPath(int arr[][])
    {
        int len1=arr.length;
        int len2=arr[0].length;
        int dp[][]=new int [len1][len2];
        dp[0][0]=arr[0][0];
        for(int i=1;i<len1;i++)
        {
            dp[i][0]=dp[i-1][0]+arr[i][0];
        }
        for(int i=1;i<len2;i++)
        {
            dp[0][i]=dp[0][i-1]+arr[0][i];
        }
        for(int i=1;i<len1;i++)
            for(int j=1;j<len2;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+arr[i][j];
            }

        return dp[arr.length-1][arr[0].length-1];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }

        }
        System.out.println(findPath(arr));
    }
}
