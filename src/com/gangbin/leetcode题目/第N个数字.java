package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 思路大致是对的，但是需要考虑几个问题
 * 计算的最后的数字是哪个，怎么确定？余数等于0是前面那个数字，余数大于0是后面那个数字
 *位数计算的结果可能会溢出的
 * @date 2019/11/6
 */
public class 第N个数字 {

    public static int findNthDigit(int n) {
        long len=1;
        long multi=1;
        long count=9*multi*len;
        while(n>count){
            multi=multi*10;
            len++;
            count+=9*multi*len;
        }
        //得到长度和上限 len multi*9
        if(len==1){
            return n;
        }
        n=n-(int) (count-9*multi*len);
        long pos=n%len;
        long num=multi;
        long i=0;
        if(pos==0){
            num+=n/len-1;
            i=pos;
        }else{
            num+=n/len;
            i=len-pos;
        }
        while(i>0){
            num/=10;
            i--;
        }
        return (int) num%10;
    }

    public static void main(String[] args) {
        int n=1000000000;
        System.out.println(findNthDigit(n));
    }
}
