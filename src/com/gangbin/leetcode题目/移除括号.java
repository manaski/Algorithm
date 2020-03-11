package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/11/3
 */
public class 移除括号 {
    public static String minRemoveToMakeValid(String s) {
        char[] chars=s.toCharArray();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(chars[i]=='('){
                count++;
            }
            if(chars[i]==')'){
                count--;
            }
            if(count<0){
                chars[i]='.';
                count=0;
            }
        }
        count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(chars[i]==')'){
                count++;
            }
            if(chars[i]=='('){
                count--;
            }
            if(count<0){
                chars[i]='.';
                count=0;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            if(c!='.'){
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="a)b(c)d";
        minRemoveToMakeValid(s);
    }
}
