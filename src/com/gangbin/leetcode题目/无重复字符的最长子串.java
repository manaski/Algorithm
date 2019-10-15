package com.gangbin.leetcode题目;

import java.util.HashMap;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        int begin=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))&&(map.get(s.charAt(i))>=begin)){
                begin=map.get(s.charAt(i))+1;
                map.put(s.charAt(i),i);
            }else{
                map.put(s.charAt(i),i);
                max=Math.max(max,i-begin+1);
            }
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        String s="123145";
        lengthOfLongestSubstring(s);
    }
}
