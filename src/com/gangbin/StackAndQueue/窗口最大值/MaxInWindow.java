package com.gangbin.StackAndQueue.窗口最大值;

/**
 * 记录滑动窗口最大值
 * 用双端队列来进行记录
 * 先从队尾进行更新，把小元素出队，把新元素加进来
 * 队头的元素是当前最大值
 */

import java.util.Deque;
import java.util.LinkedList;

public class MaxInWindow {
    public int[] getMax(int[] nums, int w){
        if(nums==null||w<1||nums.length<w){
            return null;
        }
        int index=0;   //记录结果集合中的下标
        int[] res=new int[nums.length-w+1];
        //双端队列，队列头部表示当前最大值
        //从尾部进入的元素有可能作为下一个头部元素，因此进行比较
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            //如果此时的头部元素已经过期，应该弹出去，由下一个候补元素做头元素
            if(deque.peekFirst()==i-w){
                deque.pollFirst();
            }
            //当遍历到出现窗口时进行结果记录
            if(i>=w-1){
                res[index++]=nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
