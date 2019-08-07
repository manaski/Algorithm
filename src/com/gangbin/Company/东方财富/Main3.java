package com.gangbin.Company.东方财富;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 东方财富笔试题2
 * @date 2019/8/6
 */
public class Main3 {
    /**
     *只能买卖一次的情况下，最大收益
     * @param n
     * @param vals
     * @return 最大收益
     */
    public static int getMostProfit(int n, int[] vals){
        if(n<1||vals==null||vals.length==0){
            return 0;
        }
        int maxBenefit=0;
        int minPrice=vals[0];
        for(int i=0;i<n;i++){
            if(vals[i]<minPrice){
                minPrice=vals[i];
            }
            maxBenefit=Math.max(maxBenefit,vals[i]-minPrice);
        }
        return maxBenefit;
    }

    /**
     * 可以买卖多次的情况下
     * @param vals
     * @return
     */
    public static int getMostProfit2(int[] vals){
        if(vals==null||vals.length==0){
            return 0;
        }

        int mostProfit=0;
        for(int i=1;i<vals.length;i++){
            if(vals[i]>vals[i-1]){
                mostProfit+=vals[i]-vals[i-1];
            }
        }
        return mostProfit;

    }

    /**
     * 只可以买卖二次
     * @param vals
     * @return
     */
    public static int getMostProfit(int[] vals){
        if(vals==null||vals.length==0||vals.length<2){
            return 0;
        }
        int n=vals.length;
        int[] maxP1=new int[n+1];
        int[] maxP2=new int[n+1];
        int maxR=0;
        int minV1=vals[0];
        int maxV2=vals[n-1];
        for(int i=0;i<n;i++){
            minV1=Math.min(vals[i],minV1);
            maxP1[i+1]=Math.max(maxP1[i],vals[i]-minV1);
        }
        for(int i=0;i<n;i++){
            maxV2=Math.max(vals[n-1-i],maxV2);
            maxP2[i+1]=Math.max(maxP2[i],maxV2-vals[n-1-i]);
        }
        for(int i=0;i<n-1;i++){
            maxR=Math.max(maxR,maxP1[i]+maxP2[n-i]);
        }
        System.out.println(Arrays.toString(maxP1));
        System.out.println(Arrays.toString(maxP2));
        return maxR;
    }

    public static void main(String[] args) {
        int[] val={3,5,2,8,3,4};
        int ret=getMostProfit(6,val);
        System.out.println(ret);
        System.out.println(getMostProfit2(val));
        System.out.println(getMostProfit(val));
    }
}
