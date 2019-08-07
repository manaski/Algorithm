package com.gangbin.String;

/**
 * 最长无重复子串
 */
public class LongestUnique {
    public static String maxUnique(String str){
        if(str==null||str.length()==0){
             return "";
        }
        char [] chars=str.toCharArray();
        int begin=0;
        int maxLen=0;
        int maxI=0;
        int maxJ=0;
        int[] map=new int[257];
        for(int i=0;i<chars.length;i++){
            if(map[chars[i]-'0']>=begin){//下标在讨论的范围内时，更新初始位置，当初始为0时，不会影响结果
                begin=map[chars[i]-'0'];
            }
                map[chars[i]-'0']=i+1;

            if(i-begin+1>maxLen){
                maxI=begin;
                maxJ=i;
            }
            maxLen=Math.max(maxLen,i-begin+1);
        }
        return str.substring(maxI,maxJ+1);
    }

    public static void main(String[] args) {
        String str="123458245178532";
        String res=maxUnique(str);
        System.out.println(res);
    }

}
