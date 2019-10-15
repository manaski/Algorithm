package com.gangbin.Others;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 在居民点上建立邮局，使得所有居民到达邮局的距离是最短的
 * 分为两步，先建立在任意两个位置间建立一个邮局的最小距离，中间位置距离最小
 * 再推到dp关系，新增邮局负责的空间遍历所有可能。
 * 动态规划问题，这里的变化的参数是在多长距离上建立多少邮局，距离最小
 * 这俩个变量作为动态规划的变量，推到前后关系，当数量增大一个时，新增的这个处于多长距离影响最终结果
 * @date 2019/9/8
 */
public class 邮局选址问题 {
    public static int position(int[] arr, int num){
        if(arr==null||num<0){
            return -1;
        }
        if(arr.length==1){
            return 0;
        }
        int len=arr.length;
        int[][] w=new int[len+1][len+1];   //表示在i-j上建立一个邮局的最小距离
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                w[i][j]=w[i][j-1]+arr[j]-arr[(i+j)/2];//新增一个节点最小距离可以推算的
            }
        }
//        for(int[] a:w){
//            System.out.println(Arrays.toString(a));
//        }
         int[][]dp=new int[num][len];
        for(int i=0;i<len;i++){
            dp[0][i]=w[0][i];
        }
        for(int i=1;i<num;i++){  //几个邮局
            for(int j=i+1;j<len;j++){  // 在前几个位置上, 当j<=i时，可以知道最小距离都是0
                dp[i][j]=Integer.MAX_VALUE; //最小距离初始值
                for(int k=0;k<=j;k++){
                    dp[i][j]=Math.min(dp[i-1][k]+w[k+1][j],dp[i][j]);   //w[j-k+1][j]可能越界
                }
            }
        }
        return dp[num-1][len-1];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ret=position(arr,m);
        System.out.println(ret);
    }
}
