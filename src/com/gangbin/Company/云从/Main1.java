package com.gangbin.Company.云从;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int candies=sc.nextInt();
        int n=sc.nextInt();
        if(n<=0){
            System.out.println("[]");
            return;
        }
        int[] res=new int[n];
        int index=0;
        int can=1;
        while(candies>0){
            index=index%n;
            if(candies>can){
                res[index]=can;
                candies-=can++;
            }else{
                res[index]=candies;
                break;
            }
            index++;
        }
        System.out.print("[");
        for(int i=0;i<n-1;i++){
            System.out.print(res[i]+",");
        }
        System.out.print(res[n-1]);
        System.out.print("]");

    }
}
