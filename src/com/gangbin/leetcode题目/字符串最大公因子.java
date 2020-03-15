package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/12
 */
public class 字符串最大公因子 {
    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    public static int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(3,9));
    }
}
