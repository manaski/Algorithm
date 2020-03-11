package com.gangbin.leetcode题目;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/18
 */
public class 最长的斐波那契数列 {
    public int lenLongestFibSubseq(int[] A) {
        int len=A.length;
        int maxLen=0;
        int cur=0;
        int pre=0;
        int max=0;
        HashSet<Integer> set=new HashSet<>();
        for(Integer t:A){
            set.add(t);
        }
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                max=2;
                pre=A[i];
                cur=A[j];
                int next=pre+cur;
                while(set.contains(next)){
                    max++;
                    pre=cur;
                    cur=next;
                    next=pre+cur;
                }
                maxLen=Math.max(maxLen,max);
            }
        }
        return maxLen<3?0:maxLen;
    }
    public int lenLongestFibSubseq1(int[] A) {
        HashMap<Integer,Integer> index=new HashMap<>();
        for(int i=0;i<A.length;i++){
            index.put(A[i],i);
        }
        HashMap<Integer,Integer> longest=new HashMap<>();
        int maxLen=0;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<i;j++){
                int k=index.getOrDefault(A[i]-A[j],-1);
                if(k>=0&&k<j){
                    int len=longest.getOrDefault(k*A.length+j,2)+1;
                    maxLen=Math.max(maxLen,len);
                    longest.put(j*A.length+i,len);
                }
            }
        }
        return maxLen;
    }


}
