package com.gangbin.字节跳动;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
public class Main3 {
    public static int takeNumer(int[] arr){
        int res=0;
        int i=0;
        int j=arr.length-1;
        int left=0;
        int right=0;
        while(i<=j){
            if(j-i<=1){
               res+=Math.max(arr[i],arr[j]);
               break;
            }
           left=arr[i]-arr[i+1];
           right=arr[j]-arr[j-1];
           if(left>right){
               res+=arr[i];
               i++;
           }else{
               res+=arr[j];
               j--;
           }
            if(i<=j){
                if(j-i<=1){
                    res+=Math.max(arr[i],arr[j]);
                    if(arr[i]>arr[j]){
                        res+=arr[i];
                        i++;
                    }else{
                        res+=arr[j];
                        j--;
                    }
                    continue;
                }
                left=arr[i]-arr[i+1];
                right=arr[j]-arr[j-1];
                if(left>right){
                    i++;
                }else{
                    j--;
                }
            }
//            if(arr[i]<=arr[j]){
//                res+=arr[j];
//                j--;
//            }else{
//                res+=arr[i];
//                i++;
//            }
//            if(i<=j){
//                if(arr[i]<=arr[j]){
//                    j--;
//                }else{
//                    i++;
//                }
//            }
        }
        System.out.println(res);
        return res;
    }
    public static int takeNumber2(int[] arr,int i,int j){
        if(i==j){
            return arr[i];
        }
        if(i+1==j){
            return Math.max(arr[i],arr[j]);
        }
        int res1=arr[i]-takeNumber2(arr,i+1,j);
        int res2=arr[j]-takeNumber2(arr,i,j-1);
        return Math.max(res1,res2);
    }
    public static int takeNumer1(int[] arr) {
        int len=arr.length;
        int[][]dp=new int[len][len];
        int sum=0;
        for(int i=0;i<len;i++){
            dp[i][i]=arr[i];
            sum+=arr[i];
        }
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                dp[j-i-1][j]=Math.max(arr[j-i-1]-dp[j-i][j],arr[j]-dp[j-i-1][j-1]);
            }
        }
        System.out.println((sum+dp[0][len-1])/2);
        return (sum+dp[0][len-1])/2;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       // String s=sc.nextLine();
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        takeNumer1(arr);
    }
}
