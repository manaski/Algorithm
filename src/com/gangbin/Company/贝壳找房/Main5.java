package com.gangbin.Company.贝壳找房;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/23
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str2=scanner.nextLine();
        String[] ss2=str2.split(" ");
        int n=Integer.valueOf(ss2[0]);
        int S=Integer.valueOf(ss2[1]);

        String str1=scanner.nextLine();
        String[] ss1=str1.split(" ");
        int[] arr1=new int[ss1.length];
        for(int i=0;i<ss1.length;i++){
            arr1[i]=Integer.valueOf(ss1[i]);
        }
        Arrays.sort(arr1);
        int count=0;
        int i=0;
        while(S>arr1[i]){
            S-=arr1[i];
            count++;
            i++;
        }
        System.out.println(count);
    }
}
