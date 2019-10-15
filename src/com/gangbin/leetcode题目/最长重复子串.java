package com.gangbin.leetcode题目;

import java.util.HashSet;

/**
 * @author gangbin.li
 * @description: 采用二分查找和编码方式快速判断是否是相同子串
 * @date 2019/10/1
 */
public class 最长重复子串 {
    public int search(int L, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; ++i)//搜索长度为L的窗口
            h = (h * a + nums[i]) % modulus;//进行编码，转为十进制数字

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet();
        seen.add(h);//保存当前编码
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i)
            aL = (aL * a) % modulus;//最高位对应的权重值

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;//减去最高位
            h = (h + nums[start + L - 1]) % modulus;   //增加最低位
            if (seen.contains(h))
                return start;//如果找到相同的编码，就是对应相同的字符串
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = (int)S.charAt(i) - (int)'a';
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1)
                left = L + 1;
            else
                right = L; //太长就会左移
        }
        //最后停下的位置是left+1的位置

        int start = search(left - 1, a, modulus, n, nums);//找到左边起点
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

    public static void main(String[] args) {
        String s="ababa";
    }
}
