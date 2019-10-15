package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/1
 */
public class 移除盒子的問題 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }

    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
//        if (i > j) return 0;
//        if (dp[i][j][k] > 0) return dp[i][j][k];
//
//        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++)
//            ; // optimization: all boxes of the same color counted continuously from the first box should be grouped together
//        int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);
//
//        for (int m = i + 1; m <= j; m++) {
//            if (boxes[i] == boxes[m]) {
//                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
//            }
//        }
//        dp[i][j][k] = res;
//        return res;
        if(j<i){
            return 0;
        }
        if(dp[i][j][k]>0){
            return dp[i][j][k];
        }//已经计算过一次，不再重复计算
        while(i+1<=j&&boxes[i+1]==boxes[i]){
            i++;
            k++;
        }//找到k+1个相同的盒子
        int res=(k+1)*(k+1)+removeBoxesSub(boxes,i+1,j,0,dp);
        for(int m=i+1;m<=j;m++){
            if(boxes[m]==boxes[i]){//如果发现有和当前i的颜色一样的，尝试把中间先处理掉，使得同颜色的聚集到一起，寻找最大的一种解
                res=Math.max(res,removeBoxesSub(boxes,i+1,m-1,0,dp)+removeBoxesSub(boxes,m,j,k+1,dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }

}
