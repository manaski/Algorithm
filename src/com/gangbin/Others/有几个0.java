package com.gangbin.Others;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/14
 */
public class 有几个0 {
    public static int get(int n){
        int count=0;
        long time1=System.currentTimeMillis();
        for(int i=5;i<=n;i=i+5){
            int m=i;
            while(m%5==0){
                count++;
                m=m/5;
            }
        }
        System.out.println(count);
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
        return count;
    }
    public static int get2(int n){
        long time1=System.currentTimeMillis();
        int count=0;
        int cur=5;
        while(n!=0){    //用除法不要用乘法，因为可能会发生溢出的问题
            count+=n/5;
            n=n/5;
        }
        System.out.println(count);
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
        return count;
    }
    public static int get1(int n){
        int count=0;
        while(n!=0){
            count+=n>>1;
            n=n>>1;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int n=1000000000;
        get(n);
        get2(n);
        get1(n);
    }
}
