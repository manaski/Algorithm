package com.gangbin.Company.小红书;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/3
 */
class Gift{
    int H;
    int X;
    public Gift(int x, int h) {
        H = h;
        X = x;
    }
}
public class Main {

    public static int maxLen(int[] arr){
        int[] brr=Arrays.copyOfRange(arr,0,arr.length);
        Arrays.sort(brr);
        int[][] dp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            dp[0][i]=arr[0]==brr[i]?1:0;
            dp[i][0]=arr[i]==brr[0]?1:0;
        }
        dp[0][0]=arr[0]==brr[0]?1:0;
        int maxL=0;
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[i]==brr[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                maxL=Math.max(maxL,dp[i][j]);
            }
        }
        System.out.println(maxL);
        return maxL;
    }
    public static  int MaxSale(Gift[] arr){
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Comparator<Gift>() {
            @Override
            public int compare(Gift o1, Gift o2) {
                if((o1.X-o2.X>0)){
                    return 1;
                }else if(o1.X-o2.X==0){
                    return 0;
                }
                return -1;
            }
        });
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=arr[i].H;
        }
        int ret=maxLen(res);
        System.out.println(Arrays.toString(arr));
        System.out.println(ret);
        return ret;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Gift[] gifts=new Gift[n];
        for(int i=0;i<n;i++){
            gifts[i]=new Gift(sc.nextInt(),sc.nextInt());
        }
        MaxSale(gifts);
        //int[] arr={10,2,3,1,5,2,9};
      //  maxLen(arr);
    }
}
