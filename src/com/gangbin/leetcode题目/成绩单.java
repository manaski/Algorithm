package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 出勤记录
 * @date 2019/10/1
 */
public class 成绩单 {
    public int checkRecord1(int n) {
        int[][][]dp=new int[n][3][2];

        for(int i=0;i<n;i++){
            if(i==0){
                dp[i][0][1]=1;
                dp[i][1][0]=1;
                dp[i][2][0]=1;
                continue;
            }
            if(i==1){
                dp[i][0][1]=dp[i-1][1][0]+dp[i-1][2][0];
                dp[i][1][1]=dp[i-1][1][1]+dp[i-1][2][1]+dp[i-1][0][1];
                dp[i][2][1]=dp[i-1][1][1]+dp[i-1][2][1]+dp[i-1][0][1];

                dp[i][1][0]=dp[i-1][1][0]+dp[i-1][2][0];
                dp[i][2][0]=dp[i-1][1][0]+dp[i-1][2][0];
                continue;
            }
                dp[i][0][1]=dp[i-1][1][0]+dp[i-1][2][0];//A
                dp[i][1][1]=dp[i-1][0][1]+dp[i-1][1][1]+dp[i-1][2][1];//P
                dp[i][2][1]=dp[i-1][0][1]+dp[i-1][1][1]+dp[i-2][0][1]+dp[i-2][1][1];//L
        }
        return dp[n-1][0][1]+dp[n-1][1][0]+dp[n-1][2][0]+dp[n-1][1][1]+dp[n-1][2][1];
    }
    public int checkRecord(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 3;
        if(n==2)
            return 8;
        int max=1000000007;

        long di00=2,t00=di00;
        long di10=3,t10=di10;
        long di01=1,t01=di01;
        long di11=1,t11=di11;
        long di02=1,t02=di02;
        long di12=0,t12=di12;

        for(int i=3;i<=n;i++){
            di00=(t00+t02+t01)%max;
            di10=(t00+t01+t11+t02+t12+t10)%max;
            di01=t00%max;
            di11=t10%max;
            di02=t01%max;
            di12=t11%max;

            t00=di00;
            t10=di10;
            t01=di01;
            t11=di11;
            t02=di02;
            t12=di12;

        }
        return (int)((di00+di10+di01+di11+di02+di12)%max);
    }
}
