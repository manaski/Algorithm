package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/25
 */
public class 岛屿数量 {
    public static int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
         return 0;
        }
        int len1=grid.length;
        int len2=grid[0].length;
        char[][] visit=new char[len1][len2];
        for(char[] p:visit){
            Arrays.fill(p,'*');
          //  System.out.println(Arrays.toString(p));
        }
        int label=0;
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(grid[i][j]=='1'&&visit[i][j]=='*'){
                    numIslands(grid,visit,i,j,label++);
                }
            }
        }
        for(char[] p:visit){
            System.out.println(Arrays.toString(p));
        }
        return label;
    }
    public static void numIslands(char[][]grid,char[][] visit,int x,int y,int label){
        if(x<0||x>grid.length||y<0||y>grid[0].length){
            return;
        }
        if(grid[x][y]=='1'&&visit[x][y]=='*'){
            visit[x][y]=(char)('0'+label);
        }else{
            return;
        }
        if(x-1>=0&&visit[x-1][y]=='*'){
            numIslands(grid,visit,x-1,y,label);
        }
        if(x+1<grid.length&&visit[x+1][y]=='*'){
            numIslands(grid,visit,x+1,y,label);
        }
        if(y-1>=0&&visit[x][y-1]=='*'){
            numIslands(grid,visit,x,y-1,label);
        }
        if(y+1<grid[0].length&&visit[x][y+1]=='*'){
            numIslands(grid,visit,x,y+1,label);
        }
    }

    public static void main(String[] args) {
 //       numIslands(new char[1][1]);
        char[][] c={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        for(char[] p:c){
            System.out.println(Arrays.toString(p));
        }
        numIslands(c);

    }
}
