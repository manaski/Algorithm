package com.gangbin.ArrayAndMatrix;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
public class 数组最大累加和 {
    public static int maxSum(int[] arr){
        int cur=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
             cur=cur+arr[i];
             if(cur<0){
                 cur=0;
             }else{
                 max=Math.max(max,cur);
             }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int[] arr={-1,2,3,5,-2,-6};
        maxSum(arr);
    }
}
