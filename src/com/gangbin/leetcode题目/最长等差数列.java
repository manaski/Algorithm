package com.gangbin.leetcode题目;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/31
 */
public class 最长等差数列 {
    public static int longestArithSeqLength(int[] A) {
        Map<Integer,Integer>[] maps=new Map[A.length];
        int maxLen=0;
        for(int i=0;i<A.length;i++){
            Map<Integer,Integer> mapi=new HashMap<>();
            for(int j=i-1;j>=0;j--){
                Map<Integer,Integer> record=maps[j];
                int len=0;
                if(!mapi.containsKey(A[i]-A[j])){
                    if(record!=null&&record.containsKey(A[i]-A[j])){
                        mapi.put(A[i]-A[j],len=record.get(A[i]-A[j])+1);
                    }else{
                        mapi.put(A[i]-A[j],len=2);
                    }
                }
                maxLen=Math.max(maxLen,len);
            }
            maps[i]=mapi;
        }
        System.out.println(maxLen);
        return maxLen;
    }
    public static int longestArithSeqLength2(int[] A) {
        Map<Integer,Integer>[] maps=new Map[A.length];
        int[][]dp=new int[A.length][20001];
        int maxLen=0;
        for(int i=0;i<A.length;i++){
            for(int j=i-1;j>=0;j--){
                int len=0;
                if(dp[i][A[i]-A[j]+10000]==0){
                    if(dp[j][A[i]-A[j]+10000]!=0){
                        len=dp[j][A[i]-A[j]+10000]+1;
                    }else{
                        len=2;
                    }
                    dp[i][A[i]-A[j]+10000]=len;
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        System.out.println(maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr={1,1,4,1,1};
        longestArithSeqLength2(arr);
    }
}
