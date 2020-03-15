package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/15
 */
public class 海岛的最大面积 {

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        int len=grid.length;
        int high=grid[0].length;
        for(int i=0;i<len;i++){
            for(int j=0;j<high;j++){
                //查找一个起点位置
                if(grid[i][j]==1){
                    maxArea=Math.max(findIsland(grid,i,j),maxArea);
                }
            }
        }
        return maxArea;
    }
    public static int findIsland(int[][]grid, int i, int j){
        int area=1;
        int len=grid.length;
        int high=grid[0].length;
        int[] posx={1,-1,0,0};
        int[] posy={0,0,1,-1};
        grid[i][j]=2;
        for(int k=0;k<4;k++){
            if(i+posx[k]<len&&i+posx[k]>=0
                    &&j+posy[k]<high&&j+posy[k]>=0
                    &&grid[i+posx[k]][j+posy[k]]==1){
                area+=findIsland(grid,i+posx[k],j+posy[k]);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][]grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int res=maxAreaOfIsland(grid);
        System.out.println(res);
    }
}
