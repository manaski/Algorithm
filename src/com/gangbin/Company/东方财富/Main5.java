package com.gangbin.Company.东方财富;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/23
 */
public class Main5 {
    public static int subArraySum(int[] arr) {
        if(arr==null||arr.length==0){
            return -1;
        }
        int len=arr.length;
        int[] dp1 = new int[len+ 1];
        int[] dp2 = new int[len+ 1];

        if(arr.length==1){
            return arr[0];
        }
        if(arr.length==2){
            return Math.max(arr[0],arr[1]);
        }
        dp1[1] = arr[0];
        dp1[2] = Math.max(arr[1], arr[0]);
        for (int i = 3; i < len; i++) {
            dp1[i] = Math.max(arr[i-1] + dp1[i-2], dp1[i - 1]);
        }
        dp2[2] = arr[1];
        dp2[3] = Math.max(arr[1], arr[2]);
        for (int i = 4; i <= len; i++) {
            dp2[i] = Math.max(arr[i-1] + dp2[i-2], dp2[i-1]);
        }
        return Math.max(dp1[len-1], dp2[len]);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.nextLine();
        if(str1.equals("")||str1.trim().length()==0){
            System.out.println(-1);
            return;
        }
        String[] ss1=str1.split(",");
        int[] arr1=new int[ss1.length];
        for(int i=0;i<ss1.length;i++){
            arr1[i]=Integer.valueOf(ss1[i]);
        }
        int res=subArraySum(arr1);
        System.out.println(res);

    }
}
