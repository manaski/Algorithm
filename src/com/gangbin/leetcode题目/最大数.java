package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */

public class 最大数 {
    public static String getmax(int[] arr){
        int len=arr.length;
        String[] s=new String[len];
        for(int i=0;i<len;i++){
            s[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(s, (String o1, String o2)->{
                String s1=o1+o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }
        );
        String res="";
        for(int i=0;i<s.length;i++){
            res+=s[i];
        }
        if(res.charAt(0)=='0'){
            return "0";
        }
        return res;
    }
}
