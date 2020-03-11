package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/25
 */
public class 复原IP地址 {
    public static List<String> restoreIpAddresses(String s) {
        char[] chars=s.toCharArray();
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        process(res,sb,s.toCharArray(),0,0);
        System.out.println(res);
        return res;
    }
    public static void process(List<String> res, StringBuilder sb, char[] chars, int num, int index){
        int len=chars.length;
        if(num>4||index>len){
            return;
        }
        if((len-index)<(4-num)||(len-index)>3*(4-num)){
            return;
        }
        if(num==4&&index==len){
            res.add(sb.toString().substring(1,sb.length()));
            return;
        }
        int n=0;
        if(chars[index]=='0'){
            String s="."+n;
            sb.append(s);
            process(res, sb,  chars, num+1, index+1);
            sb.delete(sb.length()-s.length(),sb.length());
            return;
        }
        for(int i=index;i<index+3&&(len-i-1)>=(3-num)&&(len-i-1)<=3*(4-num);i++){
            n=n*10+chars[i]-'0';
            if(n>255){
                return;
            }
            String s="."+n;
            sb.append(s);
            process(res, sb,  chars, num+1, i+1);
            sb.delete(sb.length()-s.length(),sb.length());
        }

    }

    public static void main(String[] args) {
        String s="25525511135";
        restoreIpAddresses(s);
    }

}
