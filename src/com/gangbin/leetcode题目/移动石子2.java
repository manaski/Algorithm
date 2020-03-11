package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/28
 */
public class 移动石子2 {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n=stones.length;
        int mx=stones[n-1]-stones[0]+1-n;//首位之间的空格数量
        mx-=Math.min(stones[n-1]-stones[n-2] - 1, stones[1]-stones[0] -1);//移动首尾某个石子后最大的步数
        int mi = mx;
        int i = 0;
        int j = 0;
        for(i = 0; i < n; ++i)
        {
            while(j + 1 < n && stones[j + 1] - stones[i] + 1 <= n)//以i为起点，找一个长度为n的分段
                ++j;  //j+1是最后一个
            int cost = n - (j - i + 1);//cost表示中间这段有几个空格，j-i+1表示的石子个数
            if(j - i + 1 == n - 1 && stones[j] - stones[i] + 1 == n - 1)
                //如果出现了长度为n的分段中有n-1个石子，且是紧挨着的，需要2步
                cost = 2;
            mi = Math.min(mi, cost);
        }
        return new int[]{mi,mx};
    }

}
