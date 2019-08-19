package com.gangbin.Company.奇虎360;

import java.util.concurrent.locks.LockSupport;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/16
 */
public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal=ThreadLocal.withInitial(()->1);

        Thread thread1=new Thread(()->{
            System.out.println(threadLocal.get());
            threadLocal.set(10);}
        ,"thread1");
        Thread thread2=new Thread(()->{
            System.out.println(threadLocal.get());
            threadLocal.set(100);}
                ,"thread2");
        thread1.start();
        thread2.start();
        Thread t=new Thread(()->{
            System.out.println("new thread is running ");
            LockSupport.park();
            System.out.println("the thread is waken");
        });
        t.start();
        System.out.println("waiting");
        Thread.sleep(2000);
        LockSupport.unpark(t);

    }
}
