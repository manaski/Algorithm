package com.gangbin.Company.拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/1
 */
public class Main2 {
    public static long cal(int a,int k){
        long res=0;
        return 0;


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        long[] count=new long[n];
        count[0]=arr[0];
        for(int i=1;i<n;i++){
            count[i]=count[i-1]*arr[i];
        }

        //期望值
        double res=0;
        long allCount=0;


        for(int j=arr[n-1];j>1;j++){
            int countj=1;
            int m=n-1;
            while(m>=0){
                if(arr[m]>=j){
                   countj++;
                }
            }
            //countJ个数字大于等于j  n
            if(countj<n){
                res+=j*(1+countj*Math.pow(j-1,countj-1))*count[n-countj-1]/(1.0*count[n-1]);
            }else{
                res+=j*(1+countj*Math.pow(j-1,countj-1))*count[n-countj-1]/(1.0*count[n-1]);
            }

        }


    }
}
