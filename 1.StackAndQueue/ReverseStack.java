package com.zuo.exercise1_stackAndQueue;
/**
 * 用递归方法翻转一个栈里的元素
 */

import java.util.Stack;

public class ReverseStack {
    public static int getAndRemoveLast(Stack<Integer>stack){
        int result=stack.pop();
        if(stack.isEmpty()){
           return result;
        }
        int i=getAndRemoveLast(stack);
        stack.push(result);
        return i;
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i=getAndRemoveLast(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        System.out.println(stack);
    }

}
