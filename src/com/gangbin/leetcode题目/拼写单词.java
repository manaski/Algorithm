package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/17
 */
public class 拼写单词 {
    public static int countCharacters(String[] words, String chars) {
        int[] charMap=new int[26];
        for(int i=0;i<chars.length();i++){
            charMap[chars.charAt(i)-'a']++;
        }
        int[] rec=new int[26];
        int len=0;
        for(int i=0;i<words.length;i++){
            Arrays.fill(rec,0);
            String s=words[i];
            int j=0;
            for(j=0;j<s.length();j++){
                rec[s.charAt(j)-'a']++;
                if(rec[s.charAt(j)-'a']>charMap[s.charAt(j)-'a']){
                    break;
                }
            }
            if(j==s.length()){
                len+=s.length();
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String[] words={"cat","bt","hat","tree"};
        String chars="atach";
        int res=countCharacters(words,chars);
        System.out.println(res);
    }
}
