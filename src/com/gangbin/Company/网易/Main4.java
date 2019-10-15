package com.gangbin.Company.网易;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class Main4 {
    public static int count=0;
    public static int fun(int[] arr){
        int res=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    res+=j-i;
                }
            }
        }
        System.out.println(res);
        return res;
    }
    public static int[] fun1(int[] arr,int start, int end){
        if(start>end){
            return null;
        }
        if(end-start<1){
            return new int[]{arr[start]};
        }
        int mid=(start+end)/2;
        int[] res1=fun1(arr,start,mid);
        int[] res2=fun1(arr,mid+1,end);
        int[] ret=merge(res1,res2);
        System.out.println(count);
        System.out.println(Arrays.toString(ret));
        return ret;
    }
    public static int[] merge(int[] arr1, int[] arr2){
        if(arr1==null&&arr2==null){
            return null;
        }
        if(arr1==null){
            return arr2;
        }
        if(arr2==null){
            return arr1;
        }
        int i=0;
        int j=0;
        int len=arr1.length+arr2.length;
        int[] res=new int[len];
        int index=0;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<arr2[j]){
                res[index++]=arr1[i];
                i++;
            }else{
                int k=i;
                while(k<arr1.length){
                    count+=j+arr1.length-k++;
                }
                res[index++]=arr2[j];
                j++;
            }
        }
        while(i<arr1.length){
            res[index++]=arr1[i];
            i++;
        }
        while(j<arr2.length){
            res[index++]=arr2[j];
            j++;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        fun1(arr,0,arr.length-1);
        System.out.println(count);
    }
}
