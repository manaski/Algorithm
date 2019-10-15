package com.gangbin.String.字符串拼接后字典序最小的;

/**
 * 返回将字符串拼接之后字典顺序最小的那个
 * 其实就是将所有字符串排序，排序方法是按照两两排序
 * 本质上是贪婪算法
 */

import java.util.Arrays;
public class LowestString {
    public String lowestString(String[] array){
        Arrays.sort(array, (o1, o2) ->
            (o1+o2).compareTo(o2+o1)
        );
         StringBuilder sb=new StringBuilder();
         for(String s:array){
             sb.append(s);
         }
         return sb.toString();
    }
}
