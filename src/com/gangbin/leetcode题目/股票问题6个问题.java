package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
public class 股票问题6个问题 {

//    base case：
//    dp[-1][k][0] = dp[i][0][0] = 0
//    dp[-1][k][1] = dp[i][0][1] = -infinity
//
//    状态转移方程：
//    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
//    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

    //只交易一次
    public int fun1(int[] arr){
        int len=arr.length;
        int[][]dp=new int[len][2];
        for(int i=0;i<len;i++){
            if(i-1<0){
                dp[i][0]=0;
                dp[i][1]=-arr[i];
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
            dp[i][1]=Math.max(dp[i-1][1],-arr[i]);//如果只能交易一次，则必须要dp[i-1][0]=0；
        }
        return dp[len-1][0];
    }
    //只交易多次
    public int fun2(int[] arr){
        int len=arr.length;
        int[][]dp=new int[len][2];
        for(int i=0;i<len;i++){
            if(i-1<0){
                dp[i][0]=0;
                dp[i][1]=-arr[i];
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-arr[i]);//如果交易无数次，则之前可以交易盈利dp[i-1][0]
        }
        return dp[len-1][0];
    }
    //只交易多次
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int gain=0;
        for(int i=1;i<prices.length;i++){
            gain=Math.max(0,prices[i]-prices[i-1])+gain;
        }
        return gain;
    }
    //只交易多次带有冷冻期
    public int fun21(int[] arr){
        int len=arr.length;
        int[][]dp=new int[len][2];
        int dp_i_0=0;
        for(int i=0;i<len;i++){
            if(i==0){
               dp[i][0]=0;
               dp[i][1]=-arr[i];
                continue;
            }
            if(i==1){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-arr[i]);
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+arr[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-arr[i]);//如果交易无数次，则之前可以交易盈利dp[i-1][0]
        }
        return dp[len-1][0];
    }
    //只交易两次
    public int fun3(int[] arr){
        int len=arr.length;
        int max_k=2;
        int[][][] dp = new int[len][max_k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int k = max_k; k >= 1; k--) {//为什么交易次数从大到小
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -arr[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + arr[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - arr[i]);
            }
        }
        return dp[len-1][2][0];
    }
    //购买两次的情况，需要四个变量
    int maxProfit2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }
    //只交易多次
    public int fun4(int[] arr,int fee){
        if(arr==null||arr.length==0){
            return 0;
        }
        int len=arr.length;
        int[][]dp=new int[len][2];
        for(int i=0;i<len;i++){
            if(i-1<0){
                dp[i][0]=0;
                dp[i][1]=-arr[i];
                continue;
            }
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+arr[i]-fee);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-arr[i]);//如果交易无数次，则之前可以交易盈利dp[i-1][0]
        }
        return dp[len-1][0];
    }


}
