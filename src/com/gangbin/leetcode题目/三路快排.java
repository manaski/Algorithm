package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 以某个值为中间值将数组分为两部分
 * @date 2019/9/16
 */
public class 三路快排 {
    public static void quickSort(int [] arr, int k){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            while(i<j&&arr[i]<=k){
                i++;
            }
            while(i<j&&arr[j]>k){
                j--;
            }
            if(i!=j){
                arr[i]=arr[j]^arr[i]^(arr[j]=arr[i]);
            }
        }
        //左边都是小于等于的，右边都是大于的
        System.out.println(Arrays.toString(arr));
        i=0;
        if(arr[j]>k){
            j--;
        }
        while(i<j){
            while(i<j&&arr[i]<k){
                i++;
            }
            while(i<j&&arr[j]==k){
                j--;
            }
            if(i!=j){
                arr[i]=arr[j]^arr[i]^(arr[j]=arr[i]);
            }
        }
        //左边都是小于的，右边都是等于的
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort2(int [] arr, int m){
        int i=0;
        int j=0;
        int k=arr.length-1;
        //i左边都是小于的，k右边都是大于的，j用来遍历
        //j只有在小于等于时才会向右移动
        //i只有小于时才会右移
        //k只有大于时才会左移
        while(j<=k){
            if(arr[j]<m){
                arr[i]=arr[j]^arr[i]^(arr[j]=arr[i]);
                System.out.println(Arrays.toString(arr));
                i++;
                j++;
            }else{
                if(arr[j]>m){
                    arr[k]=arr[j]^arr[k]^(arr[j]=arr[k]);
                    System.out.println(Arrays.toString(arr));
                    k--;
                }else{
                    j++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr={1,5,4,5,3,7,0,4,9,3,4,9,2,1,7,8};
        quickSort2(arr,5);
    }
}
