package com.gangbin.Company.拼多多;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/1
 */
public class Main1 {
    public static void sort(int[] arr,int N){
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
         int len=N;
         for(int i=0;i<arr.length;i++){
             if((1&arr[i])==1){
                 list1.add(arr[i]);
             }else{
                 list2.add(arr[i]);
             }
         }

         Collections.sort(list1,(o1,o2)->o2-o1);
         Collections.sort(list2,(o1,o2)->o2-o1);
        Arrays.sort(arr);
    //    System.out.println(Arrays.toString(arr));
         int count=0;
         for(Integer t:list2){
             System.out.print(t);
              count++;
              if(count<len){
                  System.out.print(",");
              }else{
                  break;
              }
         }

         if(count<len){
             for(Integer t:list1){
                 System.out.print(t);
                 count++;
                 if(count<len){
                     System.out.print(",");
                 }else{
                     break;
                 }
             }
         }

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] ss=s.split(";");
     //   System.out.println(Arrays.toString(ss));
        String[] ss1=ss[0].split(",");
     //   System.out.println(Arrays.toString(ss1));
        int N=Integer.valueOf(ss[1]);
        int len=ss1.length;
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=Integer.valueOf(ss1[i]);
        }
        sort(arr,N);
    }


}
