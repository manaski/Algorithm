package com.gangbin.Company.小年糕;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int cur=1;
        int pre=0;
        int min= Integer.MAX_VALUE;
        while(cur<n){
            int temp=pre;
            pre=cur;
            cur=cur+temp;
        }
        System.out.println(Math.min(cur-n,n-pre));
    }
}
