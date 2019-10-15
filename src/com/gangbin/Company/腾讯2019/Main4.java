package com.gangbin.Company.腾讯2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/20
 */
public class Main4 {
    public static void printArr(int[]arr, int k){
        int s=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
          //  System.out.println(Arrays.toString(arr));
            while(i<arr.length&&arr[i]-s==0){
                i++;
            }
            if(i==arr.length){
                while(count!=k){
                    System.out.println(0);
                    count++;
                }
                break;
            }
            System.out.println(arr[i]-s);
            count++;
            if(count==k){
                break;
            }
            s+=arr[i]-s;
        }
        while(count!=k){
            System.out.println(arr[arr.length-1]-s);
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
