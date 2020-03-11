package com.gangbin.leetcode题目;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/23
 */
class BoundedBlockingQueue {

    private LinkedList<Integer> queue=new LinkedList<>();
    private ReentrantLock lock=new ReentrantLock();
    private Condition empty=lock.newCondition();
    private Condition full=lock.newCondition();
    private Integer size=0;
    private Integer cap=null;

    public BoundedBlockingQueue(int capacity) {
        if(cap==null){
            try{
                lock.lock();
                if(cap==null){
                    cap=capacity;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try{
            while(size>=cap){
                full.await();
            }
            queue.offer(element);
            size+=1;
            empty.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        int res=-1;
        try {
            while(size==0){
                empty.await();
            }
            res=queue.pollLast();
            size-=1;
            full.signalAll();
        } finally {
            lock.unlock();
        }
        return res;
    }

    public int size() {
        return size;
    }
}
public class 实现一个有限容量阻塞队列 {
    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingQueue queue=new BoundedBlockingQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
    }
}
