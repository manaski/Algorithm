package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 拓扑排序
 *
 * @date 2019/9/28
 */
public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for(int[] cp : prerequisites) indegrees[cp[0]]++;
        LinkedList<Integer> queue = new LinkedList<>();    //队列做广度优先遍历
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) queue.addLast(i);
        }
        while(!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for(int[] req : prerequisites) {    //将节点的出度都删掉
                if(req[1] != pre) continue;
                if(--indegrees[req[0]] == 0) queue.add(req[0]);
            }
        }
        return numCourses == 0;
    }
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }
    private boolean dfs(int[][] adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;//表示在本次递归中被访问过
        if(flags[i] == -1) return true;//表示被别人访问过了，不重复访问
        flags[i] = 1; //先置为1
        for(int j = 0; j < adjacency.length; j++) {
            if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
            //如果有某个连接点递归返回false，直接false
        }
        flags[i] = -1;//退出当前递归，置为被别人访问过，对于别人来说
        return true;//没有返回false，则返回true
    }
}
