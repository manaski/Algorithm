package com.gangbin.leetcode题目;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */
class ZeroEvenOdd {
    private int n;
    private Semaphore semaphore1;
    private Semaphore semaphore2;
    private Semaphore semaphore3;
    private int count;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.count=n;
        semaphore1=new Semaphore(1);
        semaphore2=new Semaphore(0);
        semaphore3=new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            semaphore1.acquire();
            if((n&1)==0){
                semaphore3.release();
            }else{
                semaphore2.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i=i+2){
            semaphore2.acquire();
            semaphore1.release();
        }


    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i=i+2){
            semaphore3.acquire();
            semaphore1.release();
        }
    }
}

public class 打印零和奇偶数 {
}
