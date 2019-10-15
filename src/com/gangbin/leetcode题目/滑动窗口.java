package com.gangbin.leetcode题目;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class 滑动窗口 {
    public static String minWindow(String s, String t) {
        if(s==null||s.length()==0||t==null||t.length()==0){
            return "";
        }
        Map<Character,Integer> dictT=new HashMap<>();//保存目标子串的各个字母数量
        for(int i=0;i<t.length();i++){
            int count=dictT.getOrDefault(t.charAt(i),0);
            dictT.put(t.charAt(i),count+1);
        }

        int r=0;
        int l=0;
        int finished = 0;
        int required=dictT.size();
        int[] res={-1,0,0};
        Map<Character,Integer> window=new HashMap<>();
        while(r<s.length()){
            int count=window.getOrDefault(s.charAt(r),0);
            window.put(s.charAt(r),count+1);
            if(dictT.containsKey(s.charAt(r))&&window.get(s.charAt(r)).intValue()==dictT.get(s.charAt(r)).intValue()){
                finished++;
            }
            while(l<r&&finished==required){
                if(res[0]==-1||res[0]>r-l+1){
                    res[0]=r-l+1;
                    res[1]=l;
                    res[2]=r;
                }
                int n=window.get(s.charAt(l)).intValue()-1;
                window.put(s.charAt(l),n);
                if(dictT.containsKey(s.charAt(l))&&window.get(s.charAt(l)).intValue()<dictT.get(s.charAt(l)).intValue()){
                    finished--;
                }
                l++;
            }
            r++;
        }
       return res[0]==-1?"":s.substring(res[1],res[2]+1);
    }

    public static void main(String[] args) {

        String s1="ADOBECODEBANC";
        String t="ABC";
        String res=minWindow(s1,t);
        System.out.println(res);
    }
}
