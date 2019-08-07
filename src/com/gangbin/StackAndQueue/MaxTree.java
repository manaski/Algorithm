package com.gangbin.StackAndQueue;

/**
 * 以On的时间复杂度和空间复杂度生成类似大顶堆的树
 * 一般大顶堆的生成过程是？
 * 构建堆的过程，采用下沉操作可以达到n的复杂度，如果是上浮操作则为nlogn
 * 下面这种适合引用类型
 * 数组形式的直接用递归操作也可以
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * 用栈来实现，记录每个数左边和右边第一个大于该数的位置下标
 * 记录左边界和右边界，可以用栈维护一个递增的序列
 */
public class MaxTree {

    public void getMax(int[] arr){
        HashMap<Integer,Integer> lBigmap=new HashMap<>();
        HashMap<Integer,Integer> rBigmap=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
                stack.pop();
            }
             if(!stack.isEmpty()){
                 lBigmap.put(i,stack.peek());
             }else{
                 lBigmap.put(i,null);
             }
             stack.push(i);
        }
        stack.clear();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                rBigmap.put(i,stack.peek());
            }else{
                rBigmap.put(i,null);
            }
            stack.push(i);
        }

    }
}
