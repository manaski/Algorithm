package com.gangbin.Company.拼多多2019;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/25
 */
public class Main3 {
    public static long count=0;
    public static void fun(int n,int m, long k){
        StringBuilder res=new StringBuilder();
        process(n,m,res,k);

    }
    public static void process(long n, long m, StringBuilder res, long k){
      if(count==k){
          System.out.println(String.valueOf(res));
          return;
      }
      if(n>0&&count<k){
          res.append('a');
          count++;
          process(n-1, m,res, k);
          res.deleteCharAt(res.length()-1);
      }
      if(m>0&&count<k){
          res.append('b');
          count++;
          process(n,m-1,res,k);
          res.deleteCharAt(res.length()-1);
      }
    }

    public static void getK(int n, int m, long k){
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=m;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+2;
            }
            StringBuilder sb=new StringBuilder();

            int cur=0;
            while(cur<k){
                if(n>=1&&dp[n-1][m]+cur+1<k||n<1){
                    if(n>=1){
                        cur+=dp[n-1][m]+1;
                    }else{
                        cur+=1;
                    }
                    sb.append("B");
                    m--;
                }else{
                    cur+=1;
                    sb.append("A");
                    n--;
                }
            }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        long k= scanner.nextLong();
        getK(n,m,k);
        fun(n,m,k);
    }
}
