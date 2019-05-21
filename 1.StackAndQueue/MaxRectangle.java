package com.zuo.exercise1_stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 直方图求最大矩形
 */
public class MaxRectangle {
    public static int getMaxArea(int[][] arr){
        int height=arr.length;
        int length=arr[0].length;
        int[][] lens=new int[height][length];
        for(int i=0;i<height;i++){
            for(int j=0;j<length;j++){
                int h=i;
                while(h>=0&&arr[h--][j]==1){
                    lens[i][j]++;
                }
            }
        }
        int area=0;
        int maxA=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<height;i++){
            for(int j=0;j<length;j++){
                if(stack.isEmpty()||lens[i][stack.peek()]<=lens[i][j]){
                    stack.push(j);
                }else{
                    while(!stack.isEmpty()&&lens[i][stack.peek()]>lens[i][j]){
                        int index=stack.pop();
                        if(stack.isEmpty()){
                            area=lens[i][index]*(j-0);
                        }else{
                            area=lens[i][index]*(j-stack.peek());
                        }
                        maxA=Math.max(maxA,area);
                    }
                    stack.push(j);
                }
            }
            while(!stack.isEmpty()){
                int index=stack.pop();     //计算过的位置弹出去
                if(stack.isEmpty()){
                    area=lens[i][index]*(length-0);
                }else{
                    area=lens[i][index]*(length-stack.peek());
                }
                maxA=Math.max(maxA,area);
            }
        }
        return maxA;
    }

    public static void main(String[] args) {
        int[][] a={{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        int res=getMaxArea(a);
        System.out.println(res);
    }
}
