package com.gangbin.leetcode题目;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class 会议室数量 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        LinkedList<Integer> queue1=new LinkedList<>();
        queue1.push(2);
        queue1.push(1);
        queue1.push(3);
        System.out.println(queue1.peek());
    }
}
