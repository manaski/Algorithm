package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/24
 */
public class 最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        int h=matrix.length;
        int w=matrix[0].length;
        int[] heigth=new int[w];
        int maxArea=0;
        for(int i=0;i<w;i++){
            if(matrix[0][i]=='1'){
                heigth[i]=1;
            }
            maxArea=Math.max(maxArea,maxRectangle(heigth));
        }
        for(int i=1;i<h;i++){
            for(int j=0;j<w;j++){
                if(matrix[i][j]=='0'){
                    heigth[j]=0;
                }else{
                    heigth[j]=heigth[j]+1;
                }
            }
            maxArea=Math.max(maxArea,maxRectangle(heigth));
        }
        return maxArea;
    }
    public static int maxRectangle(int[] height){
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<height.length;i++){
            if(stack.isEmpty()||height[stack.peek()]<height[i]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&height[stack.peek()]>height[i]){
                    int v=stack.pop();
                    int start=-1;
                    if(!stack.isEmpty()){
                        start=stack.peek();
                    }
                    int area=height[v]*(i-start-1);
                    maxArea=Math.max(maxArea,area);
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int v=stack.pop();
            int start=-1;
            if(!stack.isEmpty()){
                start=stack.peek();
            }
            int area=height[v]*(height.length-start-1);
            maxArea=Math.max(maxArea,area);
        }
        System.out.println(maxArea);
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr={3,1,2,2,1};
        maxRectangle(arr);
        List<Integer> list=new ArrayList<>();
        list.stream().collect(Collectors.toSet());


    }


}
