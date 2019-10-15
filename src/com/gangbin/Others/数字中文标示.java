package com.gangbin.Others;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/12
 */
public class 数字中文标示 {
    public static String num1To9(int n){
        String[] s={"一","二","三","四","五","六","七","八","九"};
        return s[n-1];
    }
    public static String num1To99(int n){
        if(n<1||n>99){
            return "";
        }
        return num1To9(n/10)+"十"+num1To9(n%10);
    }
    public static String num1To999(int n){
        if(n==0){
            return "零";
        }
        if(n<1||n>999){
            return "";
        }
        return num1To9(n/100)+"百"+num1To99(n%100);
    }



}
