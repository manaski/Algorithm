package com.gangbin.leetcode题目;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/21
 */
public class 拆分单词 {
    //广度优先搜索的方法，比较好理解
    public boolean wordBreak(String s, List<String> wordDict) {
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(0);
        int[] visited=new int[s.length()];
        int start=-1;
        while(!queue.isEmpty()){
            start=queue.poll();
            if(visited[start]==0){
                for(int i=0;i<wordDict.size();i++){
                    if(s.startsWith(wordDict.get(i),start)){
                        int end=wordDict.get(i).length()+start;
                        queue.add(end);
                        if(end==s.length()){
                            return true;
                        }
                    }
                }
                visited[start]=1;
            }
        }
        return false;
    }
    //动态规划的方式更加简洁
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
