package com.gangbin.多线程;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/16
 */
class A{

}
class B{

}
public class DeadLock {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A.class){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B.class){
                        System.out.println("hello");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B.class){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A.class){
                        System.out.println("hello");
                    }
                }
            }
        }).start();

    }
}
