package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/18
 */
public class 俄罗斯套娃信封 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0){
            return 0;
        }
        Arrays.sort(envelopes,(o1,o2)->{
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else{
                return o1[0]-o2[0];
            }
        });
        int count=1;
        int[] temp=envelopes[0];
        for(int i=1;i<envelopes.length;i++){
           if(envelopes[i][0]>temp[0]&&envelopes[i][1]>temp[1]){
               count++;
               temp=envelopes[i];
           }
        }
        return count;
    }
}
