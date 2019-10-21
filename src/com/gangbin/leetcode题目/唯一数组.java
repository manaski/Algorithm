package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/15
 */
public class 唯一数组 {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int sum=0;//记录重复数字之和
        int num=0;//记录重复的数字个数
        int addnum=0;//记录把重复数字变成的数字之和
        for(int i=1;i<A.length;i++){
            if(A[i]==A[i-1]){//如果相同，记录下来
                sum+=A[i];
                num++;
            }else{
                int empn=A[i]-A[i-1]-1;//如果不同，在间隙位置插入重复的数字，插入的值以前一个数字为基础，递增
                int n=Math.min(empn,num); //间隙可能很大
                num-=n;    //减去处理掉的重复数字个数
                int s=(1+n)*n/2;
                addnum+=n*A[i-1]+s;
            }
        }
        if(num>0){
            int n=num;
            int s=(1+n)*n/2;
            addnum+=n*A[A.length-1]+s;
        }
        return addnum-sum;
    }
}
