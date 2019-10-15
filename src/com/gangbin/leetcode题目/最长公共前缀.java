package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/16
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }

        Arrays.sort(strs);
        int len=strs.length;
        int i=0;
        int j=len-1;
        int k=0;
        for(;k<strs[i].length()&&k<strs[j].length();k++){
            if(strs[i].charAt(k)!=strs[j].charAt(k)){
                break;
            }
        }
        return strs[0].substring(0,k);

    }
}
