package com.gangbin.Company.网易;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class Main3 {
    public static int getLong(int[] arr){
        if(arr.length==1){
            return 1;
        }
        int[] sum=new int[arr.length+1];//表示前i个数字相加和
        for(int i=1;i<=arr.length;i++){
            sum[i]=sum[i-1]+arr[i-1];
        }
        int[] res=new int[arr.length];
        res[0]=1;
        int last=0;
        int max=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>sum[i]-sum[last]&&res[i-1]>0){
                res[i]=res[i-1]+1;
                max=Math.max(max,res[i]);
            }else{
                res[i]=1;
                last=i;
            }
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int n=sc.nextInt();
            int[]arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
            }
            getLong(arr);
        }
    }
}
