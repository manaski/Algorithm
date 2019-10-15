package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 滑动窗口
 * @date 2019/9/28
 */
public class 字母异位词 {
    public List<Integer> findAnagrams(String s, String t) {
        // 用数组记录答案
        List<Integer> res=new ArrayList<>();
        int left = 0, right = 0;
        HashMap<Character,Integer> needs=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        for(char c:t.toCharArray()){
            needs.put(c,needs.getOrDefault(c,0)+1);
        }
        int match = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if(needs.containsKey(c1)){
                window.put(c1,window.getOrDefault(c1,0)+1);
                if(window.get(c1).equals(needs.get(c1))){
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                // 如果 window 的大小合适
                // 就把起始索引 left 加入结果
                if (right - left == t.length()) {
                    res.add(left);
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2,window.get(c2)-1);
                    if (window.get(c2) < needs.get(c2))
                        match--;
                }
                left++;
            }
        }
        return res;
    }
}
