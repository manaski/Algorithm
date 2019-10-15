package com.gangbin.tencent;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/19
 */
public class Main3 {
    public static void main(String[] args) {
        final long M=1000003;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==0){
            System.out.println(1);
            return;
        }
        int len=0;
        while(n!=0){
            n=n>>1;
            len++;
        }
        long res=1;
        for(int i=1;i<=len+1;i++){
            res*=i;
            res=res%M;
        }
        System.out.println(res);
    }

}
