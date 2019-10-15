package com.gangbin.Company;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */
class Solution {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{start[0]*n + start[1],0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0]/n;
            int y = cur[0]%n;
            for (int[] dir: dirs) {
                int d = 0;
                int tmpx = x;
                int tmpy = y;
                while (tmpx + dir[0] >= 0 && tmpx+dir[0] < m
                        && tmpy + dir[1] >= 0 && tmpy+dir[1]<n
                        && maze[tmpx+dir[0]][tmpy+dir[1]] == 0 ) {
                    tmpx = tmpx + dir[0];
                    tmpy = tmpy + dir[1];
                    d++;
                }
                if (dist[tmpx][tmpy] > dist[x][y] + d) {
                    dist[tmpx][tmpy] = dist[x][y] + d;
                    if (tmpx != destination[0] || tmpy != destination[1]) {
                        queue.add(new int[]{tmpx*n+tmpy,dist[x][y] + d});
                    }

                }
            }
        }
        int res = dist[destination[0]][destination[1]];
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}

