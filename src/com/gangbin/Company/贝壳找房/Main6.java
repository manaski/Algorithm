package com.gangbin.Company.贝壳找房;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/23
 */
public class Main6 {
    public static void pack(long[] pack, long[]count, long num, long vol){
        long n=Math.min(pack[0]/vol,num);
        count[0]+=n;
        pack[0]-=n*vol;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        long num=scanner.nextLong();

        long[] pack=new long[1];
        pack[0]=scanner.nextLong();

        long[] count=new long[1];
        long n;
        long v;
        for(int i=0;i<num;i++){
            n=scanner.nextLong();
            v=scanner.nextLong();
            pack(pack,count,n,v);
        }
        System.out.println(count[0]);

    }
}
