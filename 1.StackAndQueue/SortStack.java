package com.zuo.exercise1_stackAndQueue;

import java.util.Stack;

/**
 * 用另外一个栈来实现栈的排序
 * 每次取出stack中的一个数字，在help中按顺序进行排序
 *
 */
public class SortStack {
    public static void sorting(Stack<Integer> stack){
        Stack<Integer> help=new Stack<>();
        while(!stack.isEmpty()){
            int cur=stack.pop();    //先得到当前元素
            while(!help.isEmpty()&&help.peek()>cur){
                stack.push(help.pop());//在help中按顺序压入，如果有新的元素不满足顺序，就找到合适的位置再压入
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        sorting(stack);
        System.out.println(stack);

    }
}
