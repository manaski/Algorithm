package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/21
 */
public class 搜索单词 {
    public boolean exist(char[][] board, String word) {
        if(word==null||board==null||board.length==0||board[0].length==0){
            return false;
        }
        char[] chars=word.toCharArray();
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==chars[0]){
                    visited[i][j]=true;
                    if(process(word,0,board,i,j,visited)){
                        return true;
                    }
                    visited[i][j]=false;
                }
            }

        }
        return false;
    }
    public boolean process(String word, int index, char[][]board, int x, int y, boolean[][]visited){
        if(index>=word.length()-1){
            return true;
        }
        int len=board.length;
        int len2=board[0].length;
        boolean res=false;
        if(x+1<len&&board[x+1][y]==word.charAt(index+1)&&!visited[x+1][y]){
            visited[x+1][y]=true;
            if(process(word, index+1, board, x+1, y, visited)){
                return true;
            }
            visited[x+1][y]=false;
        }
        if(y+1<len2&&board[x][y+1]==word.charAt(index+1)&&!visited[x][y+1]){
            visited[x][y+1]=true;
           if(process(word, index+1, board, x, y+1,visited)){
               return true;
           }
            visited[x][y+1]=false;
        }
        if(x-1>=0&&board[x-1][y]==word.charAt(index+1)&&!visited[x-1][y]){
            visited[x-1][y]=true;
            if(process(word, index+1, board, x-1, y,visited)){
                return true;
            }
            visited[x-1][y]=false;
        }
        if(y-1>=0&&board[x][y-1]==word.charAt(index+1)&&!visited[x][y-1]){
            visited[x][y-1]=true;
            if(process(word, index+1, board, x, y-1,visited)){
                return true;
            }
            visited[x][y-1]=false;
        }
        return false;
    }
}
