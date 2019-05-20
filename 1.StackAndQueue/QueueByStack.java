package com.zuo.exercise1_stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 */
public class QueueByStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueByStack() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }

    public void offer(int num){
        stack1.push(num);
    }
    public int poll(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int peek(){
        if(stack2.isEmpty()){
           throw new RuntimeException();
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueByStack q=new QueueByStack();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
