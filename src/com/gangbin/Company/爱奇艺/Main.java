package com.gangbin.Company.爱奇艺;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/8
 */
public class Main {

    public static double res=0;
    public static double fun(double n, double m){
        process(n,m,1);
        return res;
    }
    public static void process(double n, double m, double p){
        if(p==0){
            return;
        }
        //A先拿。全是蓝色
        if(n<=0){
            return ;
        }
        //全是红色
        if(m<=0){
            res=res+p;
            return ;
        }
        double d1=n/(n+m);
        res=res+d1*p;         //A在这里拿到红色
        double d2=m/(n+m);   //A在这里拿到蓝色
        double b1=0;    //拿1红1蓝
        double b2=0;   //拿两个蓝色
        double b3=0;   //拿两个红色
        if(m-1>1&&n>1){
            //B拿两个
           // b1=((m-1)/(n+m-1))*(n)/(n+m-2)+((n)/(n+m-1))*(m-1)/(n+m-2);
            b1=((m-1)/(n+m-1))*(n)/(n+m-2);    //拿1红1蓝
            b2=((m-1)/(n+m-1))*(m-2)/(n+m-2);   //拿两个蓝色
           // b3=((n)/(n+m-1))*(n-1)/(n+m-2);   //拿两个红色
        }else if(m-1>1){
            b1=((m-1)/(n+m-1))*(n)/(n+m-2);   //拿1红1蓝
            b2=((m-1)/(n+m-1))*(m-2)/(n+m-2);   //拿两个蓝色
           // b3=0;   //拿两个红色
        }else if(m-1==0){
            return;
           //b1=((m-1)/(n+m-1))*(n)/(n+m-2);    //拿1红1蓝
           // b2=0;   //拿两个蓝色
          //  b3=((n)/(n+m-1))*(n-1)/(n+m-2);  //拿两个红色
        }else if(m-1>0){
            b1=((m-1)/(n+m-1))*(n)/(n+m-2);    //拿1红1蓝
            b2=0;   //拿两个蓝色
          //  b3=0;   //拿两个红色
        }else{
            b1=0;    //拿1红1蓝
            b2=0;   //拿两个蓝色
          //  b3=0;   //拿两个红色
        }
        process(n-1,  m-2,d2*p*b1);
        process(n,  m-3,d2*p*b2);
    //    process(n-2,  m-1,d2*p*b3);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        double res=fun(n,m);
        DecimalFormat df =new DecimalFormat("0.00000");
        System.out.println(df.format(res));

    }
}
