package com.gangbin.Company.有赞;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/8
 */
public class Main2 {

    public static void getCount(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int avrg=sum/arr.length;
        int count=0;
        if(sum%arr.length>1){
            count++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<avrg){
                count+=avrg-arr[i];
            }
        }
        System.out.println(count);
    }

    public static void getCount2(int[] arr){
        int count=0;
        if(arr.length==1){
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while(arr[j]-arr[i]>1){
            count+=1;
            arr[i]+=1;
            arr[j]-=1;
            if(i+1<arr.length&&arr[i]>arr[i+1]||j-1>=0&&arr[j-1]>arr[j]){
                Arrays.sort(arr);
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int[] arr=new int[m];
        for(int i=0;i<m;i++){
            arr[i]=sc.nextInt();
        }
        getCount2(arr);

    }
}
