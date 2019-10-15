package com.gangbin.Company.美团;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */
class Foo {

    Semaphore semaphore2;
    Semaphore semaphore3;

    public Foo() {
        semaphore2=new Semaphore(0);
        semaphore3=new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        semaphore2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        semaphore3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
class Foo1 {
    CountDownLatch countDownLatch2;
    CountDownLatch countDownLatch3;

    public Foo1() {
        countDownLatch2=new CountDownLatch(1);
        countDownLatch3=new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch2.countDown();

    }

    public void second(Runnable printSecond) throws InterruptedException {

        countDownLatch2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch3.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {

         countDownLatch3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

public class Main3 {

}
