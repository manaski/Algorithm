package com.gangbin.String;

/**
 * 寻找给定字符串数组中两个字符串之间最短距离
 * 如果需要在多次查询中，保证每次查询的时间复杂度低，可以
 * 把所有距离信息记录下来，每次查询时只要查表就可以了
 */

public class MinDistanceBetweenStrings {
    public static int minDistance(String[] s,String s1,String s2){
        if(s1==null||s2==null||s==null||s.length==0){
            return -1;
        }
        if(s1.equals(s2)){
            return 0;
        }
         int last1=-1;
         int last2=-1;
         int minD=Integer.MAX_VALUE;
        for(int i=0;i<s.length;i++){
            if(s[i].equals(s1)){
                last1=i;
                if(last2!=-1){
                    minD=Math.min(last1-last2,minD);
                }
            }
            if(s[i].equals(s2)){
                last2=i;
                if(last1!=-1){
                    minD=Math.min(last2-last1,minD);
                }
            }
        }
        if(minD<Integer.MAX_VALUE){
           return minD;
        }else{
            return -1;
        }
    }

}
