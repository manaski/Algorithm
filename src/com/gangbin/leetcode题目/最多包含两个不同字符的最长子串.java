package com.gangbin.leetcode题目;

import java.util.HashMap;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/20
 */
public class 最多包含两个不同字符的最长子串 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0;
        int maxLen=0;
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i],i);
            }else{
                while(map.size()==2){
                    if(map.get(chars[start])==start){
                        map.remove(chars[start]);
                    }
                    start++;
                }
                map.put(chars[i],i);
            }
            maxLen=Math.max(maxLen,i-start+1);
        }
        return maxLen;
    }
}
