package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/18
 */
public class 划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        char[] chars=S.toCharArray();
        List<Integer> res=new ArrayList<>();
        int[] map=new int[26];
        for(int i=0;i<S.length();i++){
            map[chars[i]-'a']=i;
        }
        int end=-1;
        int i=0;
        int begin=-1;
        for(;i<S.length();i++){
           end=map[chars[i]-'a'];
           for(int j=i+1;j<=end;j++){
               end=Math.max(end,map[chars[j]-'a']);
           }
           res.add(end-i+1);
           i=end+1;
        }
        return res;
    }
}
