package com.gangbin.Company.贝壳找房;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/23
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/23
 */
public class Main9 {
    public static void divide(int N,int[] w){
        int weight1=0;
        int weight2=0;
        int count1=0;
        int count2=0;
        Arrays.sort(w);
        if(N==2){
            System.out.print(Math.abs(w[0]-w[1])+" ");
            System.out.print(0);
            return;
        }
        int i=0;
        int j=N-1;
        while(j>=0){
            if(j==N-1){
                weight2+=w[j];
                count2++;
                j--;
                i=j;
            }else{
                while(weight2<weight1&&j>=0){
                    weight2+=w[j];
                    count2++;
                    j--;
                }
            }
            while(weight1<weight2&&i>=0){
                weight1+=w[i];
                count1++;
                i--;
            }
            j=i;
        }
        System.out.println(Math.abs(weight1-weight2)+" "+Math.abs(count1-count2));
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        divide(n,arr);
    }
}

