package com.gangbin.DynamicPlanning.斐波那契数列;

/**
 * @author gangbin.li
 * @description: 走台阶问题，每次可以跨越2个或者1个台阶,转化为递推问题，斐波那契数列
 * 求解问题也可以转化为矩阵的乘法，只是写起来稍微麻烦，时间复杂度降低为O(logn)
 * @date 2019/8/19
 */
public class Main {
    //f(n)=f(n-1)+f(n-2)
    public static int Feberna(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int cur=1;
        int pre=1;
        int temp;
        for(int i=2;i<n;i++){
            temp=cur;
            cur+=pre;
            pre=temp;
        }
        return cur;
    }

    //f(n)=f(n-1)+f(n-3)
    public static int Febena(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 3;
        }
        int cur=3;
        int pre=2;
        int prepre=1;
        int temp;
        for(int i=3;i<n;i++){
            temp=cur;
            cur=cur+prepre;
            prepre=pre;
            pre=temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int n=5;
        int res=Feberna(n);
        System.out.println(res);
        System.out.println(Febena(n));
    }
}
