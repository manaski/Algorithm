package com.gangbin.Company.美团;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */
class PrizePool {

    public  volatile int count;
    PrizePool(int n){
        count=n;
    }
    public void send(String input) {

        System.out.print(input);

    }
}
class ReviewEncourage {

    PrizePool prizePool;
    public Semaphore semaphore1=new Semaphore(1);
    public Semaphore semaphore2=new Semaphore(0);
    public Semaphore semaphore3=new Semaphore(0);

    private volatile int count=0;

    public ReviewEncourage(int n) {
        prizePool=new PrizePool(n);
    }      // 构造函数,n为中奖用户数

    public void bonus(PrizePool prizePool) throws InterruptedException {
        semaphore1.acquire();
        prizePool.send("A");
        count++;
        if((count&1)==1){
            semaphore2.release();
        }else{
            semaphore3.release();
        }
    }  // 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) throws InterruptedException {
        semaphore2.acquire();
        prizePool.send("B");
        semaphore1.release();
    }  // 仅能打印B，表示发放优惠券

    public void contribution(PrizePool prizePool) throws InterruptedException {
        semaphore3.acquire();
        prizePool.send("C");
        semaphore1.release();
    }  // 仅能打印C，表示发放贡献值

}
public class Main {
    public static void main(String[] args) {
        int count=0;
        int num=0;
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        ReviewEncourage re=new ReviewEncourage(num);
        PrizePool prizePool=re.prizePool;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true&&prizePool.count>0){
                        re.bonus(prizePool);
                        prizePool.count--;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true&&prizePool.count>0) {
                        re.contribution(prizePool);
                        prizePool.count--;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true&&prizePool.count>0) {
                        re.coupon(prizePool);
                        prizePool.count--;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();




    }
}
