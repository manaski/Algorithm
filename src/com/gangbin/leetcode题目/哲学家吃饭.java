package com.gangbin.leetcode题目;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/25
 */
class DiningPhilosophers {
    Semaphore semaphore=new Semaphore(4);
    ReentrantLock[] locks=new ReentrantLock[5];
    public DiningPhilosophers() {
        for(int i=0;i<5;i++){
            locks[i]=new ReentrantLock();
        }
    }
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        semaphore.acquire();
        locks[philosopher].lock();
        locks[(philosopher-1+5)%5].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[philosopher].unlock();
        locks[(philosopher-1+5)%5].unlock();
        semaphore.release();
    }
}
//限制每次只有一个人可以吃饭，效率比较低
class DiningPhilosophers1 {
    ReentrantLock lock=new ReentrantLock();
    public DiningPhilosophers1() {
    }
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        lock.lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        lock.unlock();
    }
}
class DiningPhilosophers2 {
    ReentrantLock[] locks=new ReentrantLock[5];
    public DiningPhilosophers2() {
        for(int i=0;i<5;i++){
            locks[i]=new ReentrantLock();
        }
    }
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        if((philosopher&1)==1){
            locks[philosopher].lock();
            locks[(philosopher-1+5)%5].lock();
        }else{
            locks[(philosopher-1+5)%5].lock();
            locks[philosopher].lock();
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[philosopher].unlock();
        locks[(philosopher-1+5)%5].unlock();
    }
}
public class 哲学家吃饭 {
}
