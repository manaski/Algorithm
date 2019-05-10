package com.zuo.exercise5_string;


/**
 * 把字符串中指定的字符串替换为某个其他字符串
 * 通过先把目标字符串替换为0，再把连续的0串替换为子串
 */
public class ReplaceTheString {

    public static String replace(String s,String from,String to){
        char[] c=s.toCharArray();
        int begin=-1;
        int index=0;
        for(int i=0;i<s.length();){
           if(c[i]==from.charAt(index)){
                if(begin==-1){
                    begin=i;
                }
                while(i<c.length&&index<from.length()&&c[i]==from.charAt(index)){
                    i++;
                    index++;
                }
                if(index==from.length()){
                    while(index-->0){
                        c[begin++]='0';
                    }
                }
            }else{
               i++;
               begin=-1;
               index=0;
           }

        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<c.length;){
                    if(c[i]!='0'){
                        sb.append(c[i]);
                        i++;
                      }else{
                        sb.append(to);
                        while(i<c.length&&c[i]=='0'){
                            i++;
                        }
                    }
        }
       return String.valueOf(sb);
    }


    public static void main(String[] args) {
        String s="223234235";
        s=replace(s,"232","12");
        System.out.println(s);
    }
}
