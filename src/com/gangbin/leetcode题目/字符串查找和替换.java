package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 以源字符串作为参照，对每一个位置进行判断，看是否是被替换的，如果不是就添加到结果，
 * 如果是，就将替换的添加，跳过中间被替换的
 * @date 2019/10/31
 */
public class 字符串查找和替换 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);
        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }
        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < N) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(S.charAt(ix++));
            }
        }
        return ans.toString();
    }
}
