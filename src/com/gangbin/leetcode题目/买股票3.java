package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 买股票3 {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[] left=new int[len];
        int[] right=new int[len];
        int min=prices[0];
        int gain=0;
        left[0]=0;
        for(int i=1;i<len;i++){
            gain=Math.max(gain,prices[i]-min);
            left[i]=gain;
            min=Math.min(min,prices[i]);
        }
        System.out.println(Arrays.toString(left));
        int max=prices[len-1];
        gain=0;
        right[len-1]=0;
        for(int i=len-2;i>=0;i--){
            gain=Math.max(gain,max-prices[i]);
            right[i]=gain;
            max=Math.max(max,prices[i]);
        }
        System.out.println(Arrays.toString(right));
        int res=0;
        for(int i=0;i<len;i++){
            res=Math.max(res,left[i]+right[i]);
        }
        return res;
    }
}
