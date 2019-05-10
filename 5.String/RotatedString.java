package com.zuo.exercise5_string;
/**
 * 判断一个字符串是否是由另一个字符串前后交换产生的
 */
public class RotatedString {
    public static boolean isRotatedString(String s1,String s2){
        if(s1==null||s2==null||s1.length()!=s2.length()){
            return false;
        }
        String s=s2+s2;   //很巧妙的方法，
        int index=s1.indexOf(s);       //采用KMP算法或者Sunday算法，可以On时间内完成，JDK里面的这个方法复杂度比较高，
                                       //应该是nm的复杂度
        if(index>-1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s="123456";
        String s2="456123";
        System.out.println(isRotatedString(s,s2));
    }
}
