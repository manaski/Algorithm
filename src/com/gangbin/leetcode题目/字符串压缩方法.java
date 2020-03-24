package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/16
 */
public class 字符串压缩方法 {
    public String compressString(String S) {
        if(S==null||S.length()==0){
            return "";
        }
        int len=S.length();
        StringBuilder sb=new StringBuilder();
        int cnt=1;
        char lastChar=S.charAt(0);
        sb.append(lastChar);
        int index=1;
        while(index<len){
            if(S.charAt(index)==lastChar){
                cnt++;
            }else{
                lastChar=S.charAt(index);
                sb.append(cnt).append(lastChar);
                cnt=1;
            }
            index++;
        }
        sb.append(cnt);
        return sb.length()>=len?S:sb.toString();
    }
}
