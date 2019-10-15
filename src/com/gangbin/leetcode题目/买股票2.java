package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 买股票2 {
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
}
