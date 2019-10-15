package com.gangbin.leetcode题目;


/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class 探索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;

        int i=row-1;
        int j=0;
        while(i>=0&&j<col){
            while(j<col&&target>matrix[i][j]){
                j++;
            }
            if(j>=col){
                return false;
            }
            if(target==matrix[i][j]){
                return true;
            }
            while (i>=0&&matrix[i][j]>target){
                i--;
            }
            if(i<0){
                return false;
            }
            if(target==matrix[i][j]){
                return true;
            }
        }
        return false;
    }
}
