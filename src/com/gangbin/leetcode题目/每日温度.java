package com.gangbin.leetcode题目;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class 每日温度 {
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[T.length];
        for(int i=T.length-1;i>=0;i--){
            while(!stack.isEmpty()&&T[stack.peek()]<=T[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=0;
            }else{
                res[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
        return res;

    }

    public static void main(String[] args) {
        int[] arr={89,62,70,58,47,47,46,76,100,70};
        dailyTemperatures(arr);
    }
}
