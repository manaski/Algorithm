package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/11/3
 */
public class 交换字符 {
    public int minimumSwap(String s1, String s2) {
        if(s1.length() != s2.length()) return -1;
        int x=0,y=0;
        for(int i=0;i<s1.length();++i) if(s1.charAt(i)=='x') x++;else y++;
        for(int i=0;i<s2.length();++i) if(s2.charAt(i)=='x') x++;else y++;
        if(x%2==1 || y%2==1) return -1;
        int cnt1=0,cnt2=0;
        for(int i=0;i<s1.length();++i)
        {
            if(s1.charAt(i) != s2.charAt(i))
            {
                if(s1.charAt(i)=='x') cnt1++;
                else cnt2++;
            }
        }
        return (cnt1+1)/2+(cnt2+1)/2;

    }
}
