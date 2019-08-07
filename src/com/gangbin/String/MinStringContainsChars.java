package com.gangbin.String;

/**
 * 求包含所给字符串中所有字符的最短字符串长度
 */
public class MinStringContainsChars {
    public static int getMinString(String str, String pt){
        if(pt==null||pt.length()==0||str==null||str.length()==0||str.length()<pt.length()){
            return 0;
        }
        char[] chars1=str.toCharArray();
        char[] chars2=pt.toCharArray();
        int[] map=new int[256];
        for(int i=0;i<chars2.length;i++){
             map[chars2[i]]++;
        }
        int left=0;
        int right=0;
        int match=chars2.length;
        int minLen=Integer.MAX_VALUE;
        while(right!=chars1.length){
            map[chars1[right]]--;//map表示还需要匹配的字符的个数，-1表示不需要匹配
            if(map[chars1[right]]>=0){
                match--;
            }
            if(match==0){
                while(map[chars1[left]]<0){
                    map[chars1[left++]]++;
                }
                minLen=Math.min(minLen,right-left+1);
                match++;
                map[chars1[left++]]++;//把left位置的字符丢掉，从后面一位重新开始
            }
            right++;
        }
         return minLen==Integer.MAX_VALUE?0:minLen;
    }
}
