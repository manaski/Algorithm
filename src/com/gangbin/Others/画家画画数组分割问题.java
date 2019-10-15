package com.gangbin.Others;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description:
 * 一、动态规划问题
 * 变化的是两个参数，多少个画师，多少个画，所以可以确定是需要进行遍历找最大的
 * 二、改变思考角度，二分查找
 * 确定一个上限值，每个画师不能超过这个上限值，看需要多少画师，最终找到合适的上限值，刚好等于给定的画师数量
 * @date 2019/9/8
 */
public class 画家画画数组分割问题 {
    public static int draw(int[] arr, int m){
        int len=arr.length;
        int[][]dp=new int[m][len];//表示i+1个画师，j+1个画
        //记录一下累加的和，后面会用到,表示前i个累加
        int[]map=new int[len+1];   //map下标大一个
        for(int i=1;i<=len;i++){
            map[i]=map[i-1]+arr[i-1];
        }
        System.out.println(Arrays.toString(map));
        for(int i=0;i<len;i++){
            dp[0][i]=map[i+1];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<len;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=0;k<=j;k++){   //i个画师负责k+1个画
                    //System.out.println("旧的人负责"+dp[i-1][k]);
                   // System.out.println("新的人负责"+(map[j+1]-map[k+1]));
                    dp[i][j]=Math.min(dp[i][j],Math.max(dp[i-1][k],map[j+1]-map[k+1]));
                }
               // System.out.println((i+1)+"个人负责"+(j+1)+"画所需时间"+dp[i][j]);
            }
        }
        return dp[m-1][len-1];
    }

    public static int getNeed(int[] arr, int lim){
        int res=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>lim){
                return Integer.MAX_VALUE;
            }
                sum+=arr[i];
               if(sum>lim){
                       res++;
                       sum=arr[i];
                }
        }
        return res;

    }
    public static int draw2(int[] arr, int m){
        int len=arr.length;
        if(arr.length<m){
            int max=0;
            for(int i=0;i<len;i++){
                max=Math.max(arr[i],max);
            }
            return max;
        }
        int[]map=new int[len+1];   //map下标大一个
        for(int i=1;i<=len;i++){
            map[i]=map[i-1]+arr[i-1];
        }
        int i=0;
        int j=map[len];
        int mid=0;
        while(i<=j){
            mid=(j-i)/2+i;
            int res=getNeed(arr,mid);
            if(res>m){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] arr={3,1,4,10};
        int ret=draw(arr,2);
        int r=draw2(arr,2);
        System.out.println(ret);
        System.out.println(r);
    }

}
