package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/23
 */
public class 判断IP地址 {
    public static String validIPAddress(String IP) {
        if(IP==null||IP.length()==0||IP.endsWith(":")||IP.endsWith(".")){
            return "Neither";
        }
        if(IP.contains(":")){
            String[] ss=IP.split(":");
            if(ss.length!=8){
                return "Neither";
            }
            for(int i=0;i<8;i++){
                if(ss[i]==null||ss[i].length()==0||ss[i].length()>4){
                    return "Neither";
                }
                for(int j=0;j<ss[i].length();j++){
                    if(!(ss[i].charAt(j)>='a'&&ss[i].charAt(j)<='z'
                            ||ss[i].charAt(j)>='A'&&ss[i].charAt(j)<='Z'
                            ||ss[i].charAt(j)>='0'&&ss[i].charAt(j)<='9')){
                        return "Neither";
                    }
                }
            }
         //   System.out.println("IPV6");
            return "IPV6";
        }
        if(IP.contains(".")){
            String[] ss=IP.split("\\.");
            if(ss.length!=4){
                return "Neither";
            }
            for(int i=0;i<4;i++){
                if(ss[i]==null||ss[i].length()==0||ss[i].length()>3){
                    return "Neither";
                }
                if(ss[i].length()>1&&ss[i].startsWith("0")){
                    return "Neither";
                }
                for(int j=0;j<ss[i].length();j++){
                    if(!(ss[i].charAt(j)>='0'&&ss[i].charAt(j)<='9')){
                        return "Neither";
                    }
                }
                if(Integer.valueOf(ss[i])>255){
                    return "Neither";
                }
            }
           // System.out.println("IPV4");
            return "IPV4";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        String s="2001:0db8:85a3:0:0:8A2E:0370:7334";
        validIPAddress(s);
    }
}
