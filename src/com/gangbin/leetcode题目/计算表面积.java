package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
public class 计算表面积 {
    public int surfaceArea(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int len1=grid.length;
        int len2=grid[0].length;
        int area=0;
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(grid[i][j]>0){
                    area+=2;
                    for(int k=0;k<4;k++){
                        int ni=i+dr[k];
                        int nj=j+dc[k];
                        int nv=0;
                        if(ni>=0&&ni<len1&&nj>=0&&nj<len2){
                            nv=grid[ni][nj];
                        }
                        area+=Math.max(grid[i][j]-nv,0);//只计算每个位置四个方向的  贡献的面积，和相邻位置有关
                    }
                }
            }
        }
        return area;
    }
}
