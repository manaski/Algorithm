package com.gangbin.Company.小红书;

import java.util.PriorityQueue;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/19
 */
public class Main5 {
    public static void testQueue(PriorityQueue<Integer> queue){
        queue.offer(5);
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        while(!queue.isEmpty()){
            System.out.print(queue.poll());
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->o2-o1);
        testQueue(queue);
    }
}
