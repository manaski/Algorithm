package com.gangbin.剑指Offer;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/16
 */
public class 坐旋转字符串 {
    public String reverseLeftWords(String s, int n) throws InterruptedException {
        if(s==null||s.length()==0){
            return "";
        }
        return s.substring(n)+s.substring(0,n);
    }


}
