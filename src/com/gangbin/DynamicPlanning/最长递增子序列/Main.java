package com.gangbin.DynamicPlanning.最长递增子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 最长递增子序列
 * @date 2019/8/19
 */
public class Main {
    public static int[] getSubList(int[] arr){
        int[] dp=new int[arr.length];//表示以i结尾的最长序列长度
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }
    public static int[] getSubList2(int[] arr){
        int[] dp=new int[arr.length];
        int[] ends=new int[arr.length];
        ends[0]=arr[0];
        int right=0;
        int l=0;
        int r=right;
        int m=0;
        for(int i=0;i<arr.length;i++){
            l=0;
            r=right;
            while(l<=r){
                m=(l+r)/2;
                if(arr[i]>ends[m]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }//l最后的值会到达大于arr[i]的第一数字的位置
            right=Math.max(right,l); //right其实表明了长度值
            ends[l]=arr[i];
            dp[i]=l+1;
        }
        return dp;

    }
    public static int[] getSub(int[] dp, int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        int index=0;
        int len=0;

        for(int i=dp.length-1;i>=0;i--){
            if(dp[i]>len){
                len=dp[i];
                index=i;
            }
        }

        int[] res=new int[len];
        res[--len]=arr[index];
        int i=index-1;
        while(i>=0){
            if(arr[i]<arr[index]&&dp[i]+1==dp[index]){
                res[--len]=arr[i];
                index=i;
            }
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int[] dp=getSubList(arr);
    //    System.out.println(Arrays.toString(dp));
        int[] res=getSub(dp,arr);
        System.out.println(Arrays.toString(res));

    }

}
