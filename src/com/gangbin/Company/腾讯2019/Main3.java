package com.gangbin.Company.腾讯2019;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/20
 */
public class Main3 {
    public static void getPart(int[] arr) {
        int len=arr.length/2;
        int all = 0;  //总和
        for (int i = 0; i < arr.length; i++) {
            all += arr[i];
        }
        int[][] fight = new int[arr.length+1][all/2+1];
        for (int i = 1; i <arr.length+1; i++) {
            for (int j = 1; j<all/2+1; j++) {
                fight[i][j] = fight[i-1][j];
                if (j-arr[i-1]>= 0 && j-arr[i-1]<all / 2 + 1) {
                    fight[i][j] = Math.max(fight[i][j], fight[i-1][j-arr[i-1]]+arr[i-1]);
                }
            }
        }
        int res=fight[arr.length][all/2];
        if(res>all-res){
            System.out.print(res+" ");
            System.out.print(all-res);
        }else{
            System.out.print((all-res)+" ");
            System.out.print(res);

        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=null;
        for(int i=0;i<n;i++){
            int m= scanner.nextInt();
             arr=new int[m];
            for(int j=0;j<m;j++){
                arr[j]= scanner.nextInt();
            }
            getPart(arr);
        }
    }
}
