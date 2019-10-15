package com.gangbin.Company.腾讯2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/20
 */
public class Main41 {
    public static void printArr(int[]arr, int k){
        int count=0;
        for(int i=0;i<arr.length;i++){
            while(i<arr.length&&arr[i]==0){
                i++;
            }
            if(i==arr.length){
                while(count!=k){
                    System.out.println(0);
                    count++;
                }
                break;
            }
           // System.out.println(Arrays.toString(arr));
            System.out.println(arr[i]);
            count++;
            for(int j=i+1;j<arr.length;j++){
                arr[j]=arr[j]-arr[i];
            }
            arr[i]=0;
            if(count==k){
                break;
            }
        }
        while(count!=k){
            System.out.println(arr[arr.length-1]);
            count++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }
        Arrays.sort(arr);
        printArr(arr,k);
    }
}
