package com.gangbin.Company.京东;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/24
 */
public class Main2 {
    public static void setArr(int[] arr1,int[] arr2){
        int len=arr1.length;
        int maxV=arr1[0];
        for(int i=0;i<len;i++){
            if(maxV<arr1[i]){
                continue;
            }
            maxV=Math.max(maxV,arr1[i]);
            for(int j=0;j<i;j++){
                if(arr1[j]>arr1[i]){
                    arr2[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
    public static int getCount(int[] arr){
        int count=0;
        int index=arr.length-1;
        int maxStep=0;
        int maxIndex=0;
        while(index>=0){
            if(arr[index]>0){
                maxStep=Math.max(maxStep,arr[index]);
               maxIndex=maxStep==arr[index]?index:maxIndex;
                if(arr[index-1]>0){
                    index--;
                }else{
                    index=maxIndex-maxStep;
                }
            }else{
                count++;
                index--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            int r=sc.nextInt();
            arr[i]=r;
        }
        setArr(arr,arr2);
        int ret=getCount(arr2);
        System.out.println(ret);
    }
}
