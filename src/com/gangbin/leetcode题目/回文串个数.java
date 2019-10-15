package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class 回文串个数 {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=count(s, i, i);
            count+=count(s, i, i+1);
        }
        return count;

    }
    public int count(String s, int start, int end ){
        int res=0;
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            res++;
            start--;
            end++;
        }
        return res;
    }
}
