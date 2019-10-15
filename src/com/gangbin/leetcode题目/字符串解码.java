package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/25
 */
public class 字符串解码 {
    public String decodeString(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        return decodeString(s,0,s.length()-1);
    }
    public String decodeString(String s,int begin, int end){
        StringBuilder sb=new StringBuilder();
        int index=begin;
        while(index<=end){
            if(s.charAt(index)>='a'&&s.charAt(index)<='z'
                    ||s.charAt(index)>='A'&&s.charAt(index)<='Z'){
                sb.append(s.charAt(index));
                index++;
            }else{
                if(s.charAt(index)>='0'&&s.charAt(index)<='9'){
                    int num=index+1;
                    while(s.charAt(num)>='0'&&s.charAt(num)<='9'){
                        num++;
                    }
                    int count=Integer.valueOf(s.substring(index,num));
                    index=num;
                    int start=index+1;
                    int left=1;
                    while(start<=end&&left>0){
                        if(s.charAt(start)=='['){
                            left++;
                        }
                        if(s.charAt(start)==']'){
                            left--;
                        }
                        start++;
                    }//肯定可以找到的一个右括号
                    int stop=start-2;
                    start=index+1;
                    String mid=decodeString(s,start,stop);
                    for(int i=0;i<count;i++){
                        sb.append(mid);
                    }
                    index=stop+2;
                }
            }

        }
        return sb.toString();
    }
}
