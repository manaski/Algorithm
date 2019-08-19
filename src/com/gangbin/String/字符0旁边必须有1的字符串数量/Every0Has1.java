package com.gangbin.String.字符0旁边必须有1的字符串数量;

/**
 * 给定字符串长度，由01组成，每个0左边必须有一个1,分析递推关系，找到规律是重点
 * 总的可能性
 * 两种方法实现
 * 1.递归方法
 * 2.斐波那契数列方法
 * 设变量p(i)表示0-i-1都满足要求，且i-1为1的情况下，还有多少种情况，则可以递推出关系
 * p(i)=p(i+1)+p(i+2)  斐波那契数列
 */
public class Every0Has1 {
    public static int getNum(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int cur=2;
        int pre=1;
        int temp=0;
        for(int i=n-2;i>0;i--){
            temp=cur;
            cur+=pre;
            pre=temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int n=4;
        int res=getNum(n);
        System.out.println(res);
    }
}
