package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/24
 */
public class 戳气球 {
    public int maxCoins(int[] nums){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        list.add(1);
        int n=list.size();
        int[][] dp=new int[n][n];
        for(int len=2;len<n;len++){//最外层以长度作为遍历的量
            for(int i=0;i<n-len;i++){//内部以起点位置作为遍历量
                int j=i+len;
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]+list.get(i)*list.get(k)*list.get(j));
                }
            }
        }
        System.out.println(dp[0][n-1]);
        return dp[0][n-1];

    }

}
