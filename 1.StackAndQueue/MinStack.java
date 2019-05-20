package com.zuo.exercise1_stackAndQueue;

import java.util.Stack;

/**
 * 设计能够快速得到最小值的栈
 * 用两个栈，分别存储数据和记录当前数据中的最小值
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int num){
        stackData.push(num);
        if(stackMin.isEmpty()){
            stackMin.push(num);
        }else{
            if(num<=stackMin.peek()){
               stackMin.push(num);
            }
        }
    }

    public int pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("empty stack");
        }
        int value= stackData.pop();
        if(value==stackMin.peek()){
            stackMin.pop();
        }
        return value;

    }
    public int getMin(){
        if(stackMin.isEmpty()){
            throw new RuntimeException();
        }
        return stackMin.peek();
    }

}
