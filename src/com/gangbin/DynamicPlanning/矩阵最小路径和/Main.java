package com.gangbin.DynamicPlanning.矩阵最小路径和;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/19
 */
public class Main {
    /**
     * 采用动态规划方法找到路径，可以尝试从头开始或者从结尾开始推导递推公式，找到递推关系
     * 二维动态数组如果不需要保留中间结果的话可以压缩为一维数组
     * @param path
     * @return
     */
     public static int getPath(int[][] path){
         if(path==null||path.length==0||path[0].length==0){
             return 0;
         }
         int row=path.length;
         int col=path[0].length;
         int [] dp=new int[col];
         dp[0]=path[0][0];
         for(int i=1;i<col;i++){
             dp[i]+=dp[i-1]+path[0][i];
         }
         for(int i=1;i<row;i++){
             dp[0]+=path[i][0];
             for(int j=1;j<col;j++){
                 dp[j]=Math.min(dp[j],dp[j-1])+path[i][j];
             }
         }
         return dp[col-1];
     }
    public static void main(String[] args) {
         int[][] a={{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        int res=getPath(a);
        System.out.println(res);

    }
}
