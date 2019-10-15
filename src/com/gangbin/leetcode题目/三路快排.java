package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
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
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort2(int [] arr, int m){
        int i=0;
        int j=0;
        int k=arr.length-1;
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
