package com.gangbin.剑指Offer;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/16
 */
class FizzBuzz {
    private int n;
    private volatile int cnt;

    private Semaphore semaphore1=null;

    public FizzBuzz(int n) {
        this.n = n;
        cnt=1;
        semaphore1=new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true){
            try{
                semaphore1.acquire();
                if(cnt>n){
                    return;
                }
                if(cnt%3==0&&cnt%5!=0){
                    printFizz.run();
                    cnt++;
                }
            }finally{
                semaphore1.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true){
            try{
                semaphore1.acquire();
                if(cnt>n){
                    return;
                }
                if(cnt%3!=0&&cnt%5==0){
                    printBuzz.run();
                    cnt++;
                }
            }finally{
                semaphore1.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true){
            try{
                semaphore1.acquire();
                if(cnt>n){
                    return;
                }
                if(cnt%3==0&&cnt%5==0){
                    printFizzBuzz.run();
                    cnt++;
                }
            }finally{
                semaphore1.release();
            }
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true){
            try{
                semaphore1.acquire();
                if(cnt>n){
                    return;
                }
                if(cnt%3!=0&&cnt%5!=0){
                    printNumber.accept(cnt);
                    cnt++;
                }
            }finally{
                semaphore1.release();
            }
        }
    }
}
public class 多线程 {

}
