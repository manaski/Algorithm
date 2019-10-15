package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/2
 */
public class 重排列为2的幂方 {
    public boolean reorderedPowerOf2(int N) {
        int len=getLen(N);
        int i=1;
        int[] target=getNum(N);
        while(i<N&&getLen(i)<len){
            i=i*2;
        }
        while(i<N){
            int[] count=getNum(i);
            System.out.println(Arrays.toString(count));
            for(int j=0;j<10;j++){
                if(count[j]!=target[j]){
                    break;
                }
                if(j==9){
                    return true;
                }
            }
            i=i*2;
        }
        return false;
    }
    public int[] getNum(int N){
        int[] count=new int[10];
       while(N>0){
           count[N%10]++;
           N=N/10;
       }
       return count;
    }
    public int getLen(int N){
        int len=0;
        while(N>0){
            len++;
            N=N/10;
        }
        return len;
    }

}
