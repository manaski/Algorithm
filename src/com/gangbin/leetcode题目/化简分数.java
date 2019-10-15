package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/24
 */
public class 化简分数 {
    public static int[] fraction(int[] cont) {
        int len=cont.length-1;
        if(len<1){
            return new int[]{cont[0],1};
        }
        int[] res=new int[2];
        int a2=-1;
        int a1=-1;
        int m=cont[len];
        int n=1;
        while(len>0){
            a1=cont[len-1];
            int temp=m;
            m=a1*m+n;
            n=temp;
            int a=gongyue(m,n);
            m=m/a;
            n=n/a;
            len--;
        }
        System.out.println(m+" "+n);
        return new int[]{m,n};

    }

    public static int gongyue(int n, int m){//求最大公约数
        if(m==0){
            return n;
        }
        return gongyue(m,n%m);
    }

    public static void main(String[] args) {
        int t=gongyue(12,9);
        System.out.println(t);
        fraction(new int[]{0, 0, 3});
    }
}
