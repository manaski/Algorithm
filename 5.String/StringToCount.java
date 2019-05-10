package com.zuo.exercise5_string;

public class StringToCount {
    public static String getStringCount(String s){
        if(s==null||s.length()==0){
            return "";
        }
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=0;i<c.length;){
            if(i!=0){
                sb.append("_").append(c[i]);
            }else{
                sb.append(c[i]);
            }

             while(i+1<c.length&&c[i+1]==c[i]){
                 i++;
                 count++;
             }
             sb.append('_').append(count);
             i++;
             count=1;
        }
        return sb.toString();
    }

    public static String getCountString(String s){
        if(s==null||s.length()==0){
            return "";
        }
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=0;i<c.length;i++){
            if(c[i]=='_'){
                count++;
                if(count%2==0){
                    int n=c[i+1]-'0';
                    char ch=c[i-1];
                    while(n-->0){
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="aavbvv";
        String res=getStringCount(s);
        System.out.println(res);
        System.out.println(getCountString(res));
    }

}
