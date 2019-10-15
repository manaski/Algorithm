package com.gangbin.Company.东方财富;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/23
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        String[] ss1=str1.split(",");
        int[] arr1=new int[ss1.length];
        for(int i=0;i<ss1.length;i++){
            arr1[i]=Integer.valueOf(ss1[i]);
        }
        String[] ss2=str2.split(",");
        int[] arr2=new int[ss2.length];
        for(int i=0;i<ss2.length;i++){
            arr2[i]=Integer.valueOf(ss2[i]);
        }

        for(int i=0;i<arr2.length;i++){
            int index=0;
            for(int j=0;j<arr1.length;j++){
                if(arr1[j]==arr2[i]){
                    arr1[j]=Integer.MAX_VALUE;
                    for(int k=j+1;k<arr1.length;k++){
                        if(arr1[k]!=Integer.MAX_VALUE){
                            System.out.print(arr1[k]+",");
                        }
                    }
                }
            }
        }

    }
}
