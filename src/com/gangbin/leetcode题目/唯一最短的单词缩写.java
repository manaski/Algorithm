package com.gangbin.leetcode题目;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/21
 */
public class 唯一最短的单词缩写 {
    public String minAbbreviation(String target, String[] dictionary) {
        Set<String> set=getAbbr(target);
        List<String> list=new ArrayList<>(set);
        Collections.sort(list,(o1,o2)->o1.length()-o2.length());
        for(String p:list){
            int i=0;
            for(;i<dictionary.length;i++){
                String s=dictionary[i];
                if(s.length()==target.length()&&isMatch(s,p)){
                    break;
                }
            }
            if(i==dictionary.length){
                return p;
            }
        }
        return "";
    }
    public static Set<String> getAbbr(String target){
        Set<String> abbr=new HashSet<>();
        abbr.add(target);
        int len=target.length();
        for(int i=1;i<=target.length();i++){
            for(int j=0;j<=len-i;j++){
                abbr.add(target.substring(0,j)+i+target.substring(j+i,len));
            }
        }
        return abbr;
    }
    public static boolean isMatch(String str, String pex){
        int num=0;
        int index=0;
        for(int i=0;i<pex.length();i++){
            if(pex.charAt(i)>='0'&&pex.charAt(i)<='9'){
                num=num*10+pex.charAt(i)-'0';
                continue;
            }
            if(num!=0){
                index=num+index;
                num=0;
            }
            if(str.charAt(index)!=pex.charAt(i)){
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="abcdef";
        String p="a3ef";
        System.out.println(getAbbr(s));;


    }

}
