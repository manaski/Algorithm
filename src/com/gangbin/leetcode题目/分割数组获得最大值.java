package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/17
 */
public class 分割数组获得最大值 {
    //用递归循环的方式
    public int maxSumAfterPartitioning1(int[] A, int K) {
        return maxSum(A,0,K);
    }
    public int maxSum(int[] A, int index, int K) {
        int maxVal=0;
        //表示以i个数字为一组
        int i=0;
        int maxSum=0;
        for(i=0;i<K&&index+i<A.length;i++){
            maxVal=Math.max(A[index+i],maxVal);
            maxSum=Math.max(maxSum,maxVal*(i+1)+maxSum(A,index+i+1,K));
        }
        return maxSum;
    }
    //用动态规划的方式
    public static int maxSumAfterPartitioning(int[] A, int K) {
         int len=A.length;
         int[]dp=new int[len+1];
         dp[len-1]=A[len-1];
         int maxVal=0;
         int maxSum=0;
         for(int i=len-2;i>=0;i--){
             maxVal=A[i];
             maxSum=A[i]+dp[i+1];
             for(int j=1;j<K&&i+j<len;j++){
                 maxVal=Math.max(maxVal,A[i+j]);
                 maxSum=Math.max(maxSum,maxVal*(j+1)+dp[i+j+1]);
             }
             dp[i]=maxSum;

         }
         return dp[0];
    }

    public static void main(String[] args) {
        int[] arr={1,15,7,9,2,5,10};
        int res=maxSumAfterPartitioning(arr,3);
        System.out.println(res);
    }
}
