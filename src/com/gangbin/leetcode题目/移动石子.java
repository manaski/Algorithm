package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/27
 */
public class 移动石子 {
    public static int[] numMovesStones(int a, int b, int c) {
        int[] arr={a,b,c};
        Arrays.sort(arr);
        int[] res=new int[2];
        if(arr[1]-arr[0]==1||arr[2]-arr[1]==1){
            res[0]=arr[1]-arr[0]>1||arr[2]-arr[1]>1?1:0;
        }else  if(arr[1]-arr[0]==2||arr[2]-arr[1]==2){
            res[0]=1;
        }else{
            res[0]=2;
        }
        res[1]=arr[2]-arr[1]-1+arr[1]-arr[0]-1;
        return res;
    }

    public static void main(String[] args) {
        numMovesStones(1,4,7);
    }
}
