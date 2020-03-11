package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/29
 */
public class 最长的山脉 {
    public static int longestMountain(int[] A) {
        int maxlen=0;
        int i=0;
        int begin=0;
        int end=0;
        if(A.length<3){
            return 0;
        }
        while(i+1<A.length){
            begin=i;
            while(i+1<A.length&&A[i+1]<=A[i]){//开头不是上升序列
                begin=i+1;
                i++;
            }
            while(i+1<A.length&&A[i+1]>A[i]){//上升序列
                i++;
            }
            if(i+1<A.length&&A[i+1]==A[i]){//如果中间有相等重新开始
               continue;
            }
            end=i;
            while(i+1<A.length&&A[i+1]<A[i]){//下降序列
                i++;
            }
            if(end==i){ //如果没有下降序列，则重新开始
                continue;
            }
            maxlen=Math.max(maxlen,i-begin+1);
        }
        System.out.println(maxlen);
        return maxlen>=3?maxlen:0;
    }

    public static void main(String[] args) {
        int[] A={1,5,4,3,8,1};
        longestMountain(A);
    }
}
