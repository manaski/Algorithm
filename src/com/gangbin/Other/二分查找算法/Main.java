package com.gangbin.Other.二分查找算法;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/19
 */
public class Main {
    public static void find(int[] arr, int target){
        int l=0;
        int r=arr.length-1;
        int m=0;
        while(l<=r){
            m=(l+r)/2;
             if(arr[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        System.out.println(l);
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,7};
        int target=6;
        find(arr,target);

    }
}
