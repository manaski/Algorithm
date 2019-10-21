package com.gangbin.多线程;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/17
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is running");
                for(int i=0;i<40;i++){
                    System.out.println(i);
                }

            }
        },"线程1");
        t1.start();//注意这里是由主线程进行调用的
        t1.join();//这里是主线程调用的，在内部，主线程获得t1的锁之后，判断t1是否存活，调用wait方法进行等待，
                  // 这里调用wait的是主线程，所以是主线程等待t1状态结束
        System.out.println("主线程执行");
    }
}
