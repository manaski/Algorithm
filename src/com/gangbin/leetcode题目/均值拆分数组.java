package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/2
 */
public class 均值拆分数组 {
    public boolean splitArraySameAverage(int[] A) {
        int len=A.length;
        Arrays.sort(A);
        int sum=0;
        for(int t:A){
            sum+=t;
        }
        for(int i=1;i<=len/2;i++){
            if((sum*i)%len==0&&find(A,0,i,(sum*i)/len)){
               return true;
            }
        }
        return false;
    }
    //深度优先搜索
    public boolean find(int[] A,int begin, int n, int sum){
         if(n==0){
             return sum==0;
         }
         if(sum<n*A[begin]){//排序的好处
             return false;
         }
         for(int i=begin;i<=A.length-n;i++){
             if(i>begin&&A[i]==A[i-1]){
                 continue;
             }
             if(find(A,i+1,n-1,sum-A[i])){
                 return true;
             }
         }
         return false;
    }
}
