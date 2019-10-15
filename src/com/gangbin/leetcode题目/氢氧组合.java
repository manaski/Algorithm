package com.gangbin.leetcode题目;

import java.util.concurrent.Semaphore;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */
class H2O {

    Semaphore semaphore1;//氧气
    Semaphore semaphore2;//氢气
    public H2O() {
        semaphore1=new Semaphore(0);
        semaphore2=new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphore2.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphore1.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphore1.release(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        semaphore2.release(2);
    }
}
public class 氢氧组合 {
}
