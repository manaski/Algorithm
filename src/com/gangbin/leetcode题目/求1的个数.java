package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
public class 求1的个数 {
    public static int countDigitOne(int n) {
        int len=0;
        int num=n;
        int div=1;
        if(n<1){
            return 0;
        }
        while(num>0){
            len++;
            num/=10;
        }
        div=(int)Math.pow(10,len-1);//这里计算出长度之后再计算除数，避免溢出问题
        int f=n/div;
        int res=0;
        res=f==1?n%div+1:div;
        res+=f*(len-1)*(div/10);//这里也是先除以10，再相乘，避免溢出问题
        res+=countDigitOne((n%div));
        return res;
    }

    public static void main(String[] args) {
       int t= countDigitOne(824883294);
        System.out.println(t);
    }
}
