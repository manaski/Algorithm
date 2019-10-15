package com.gangbin.Company.京东;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/24
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            int r=sc.nextInt();
            arr[i]=r;
            arr2[i]=r;
        }
        Arrays.sort(arr2);
        int count=0;
        for(int i=0;i<n;){
            if(arr[i]==arr2[i]){
                count++;
                i++;
            }else{
                int index=i;
                for(;index<n;index++){
                    if(arr2[index]==arr[i]){
                        break;
                    }
                }
                count++;
                i=index+1;
            }
        }
        System.out.println(count);
    }

}
