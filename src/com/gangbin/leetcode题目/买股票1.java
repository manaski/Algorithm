package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 买股票1 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int gain=0;
        for(int i=0;i<prices.length;i++){
            gain=Math.max(gain,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return gain;
    }
}
