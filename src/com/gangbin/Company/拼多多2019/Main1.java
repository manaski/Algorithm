package com.gangbin.Company.拼多多2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/25
 */
public class Main1 {
    public static long fun(int[] arr, int m){
        if(arr==null||arr.length==0){
            return 0;
        }
        Arrays.sort(arr);
        int len=arr.length;
        int realen=m*2;
        long sum=0;
        for(int i=0;i<m;i++){
            sum+=arr[i]*arr[realen-i-1];
        }
        System.out.println(sum);
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m= scanner.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }
        fun(arr,m);
    }
}
