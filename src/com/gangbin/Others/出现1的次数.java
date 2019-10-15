package com.gangbin.Others;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/14
 */






public class 出现1的次数 {
    public static int solution1(int num) {
        if (num < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i != num + 1; i++) {
            count += get1Nums(i);
        }
        return count;
    }

    public static int get1Nums(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                res++;
            }
            num /= 10;
        }
        return res;
    }

    public static int solution2(int num) {
        if (num < 1) {
            return 0;
        }
        int len = getLenOfNum(num);
        if (len == 1) {
            return 1;
        }
        int tmp1 = powerBaseOf10(len - 1);
        int first = num / tmp1;
        int firstOneNum = first == 1 ? num % tmp1 + 1 : tmp1;
        int otherOneNum = first * (len - 1) * (tmp1 / 10);
        return firstOneNum + otherOneNum + solution2(num % tmp1);
    }

    public static int getLenOfNum(int num) {
        int len = 0;
        while (num != 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    public static int powerBaseOf10(int base) {
        return (int) Math.pow(10, base);
    }

    public static int getcount(int num){
        if(num<1){
            return 0;
        }
        int len=getLen(num);
        if(len==1){
            return 1;
        }
        int temp=(int) Math.pow(10,len-1);
        int firstNum=num/temp;
        int firstCount=firstNum==1?num%temp+1:temp;
        int otherCount=firstNum*(len-1)*temp/10;
        return firstCount+otherCount+getLen(num%temp);
    }
    public static int getLen(int num){
        int count=0;
        while(num!=0){
            num=num/10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ret=solution2(n);
        System.out.println(ret);
    }

}
