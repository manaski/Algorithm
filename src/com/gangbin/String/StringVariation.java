package com.gangbin.String;

import java.util.HashMap;
import java.util.Map;
/**
 * 判断是否两个字符串含有相同的字符
 */
public class StringVariation {
    public static boolean isVariation(String s1, String s2){
        Map<Character,Integer> map=new HashMap<>();
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        //遍历s1
        for(int i=0;i<c1.length;i++){
            if(map.containsKey(c1[i])){
                map.put(c1[i],map.get(c1[i])+1);
            }else{
                map.put(c1[i],1);
            }
        }
        //遍历s2
        for(int i=0;i<c2.length;i++){
            if(map.containsKey(c2[i])){
                map.put(c2[i],map.get(c2[i])-1);
                if(map.get(c2[i])==0){
                    map.remove(c2[i]);
                }
            }else{
                return false;
            }
        }
        if(map.size()>0){
            return false;
        }
        else
            return true;
    }
    public static void main(String[] args) {
     String s1="1";
     String s2="6255314";
        System.out.println(isVariation(s1,s2));
    }
}
