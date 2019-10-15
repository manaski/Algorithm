package com.gangbin.leetcode题目;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/29
 */
class car{
    int time;
    int endTime;
    int weight;

    public car(int weight,int time) {
        this.time = time;
        this.weight = weight;
        this.endTime=time;
    }

    @Override
    public String toString() {
        return "car{" +
                "time=" + time +
                ", endTime=" + endTime +
                ", weight=" + weight +
                '}';
    }
}
public class 过桥问题 {

    public static int getTime(car[] cars, int w){
        PriorityQueue<car> queue=new PriorityQueue<>(new Comparator<car>() {
            @Override
            public int compare(car o1, car o2) {
                return o1.endTime-o2.endTime;
            }
        });
        int timebias=0;
        int curW=0;
        int i=0;
        while(i<cars.length){
            while(i<cars.length&&curW+cars[i].weight<=w){//往里加
                cars[i].endTime=cars[i].endTime+timebias;
                queue.offer(cars[i]);
                curW+=cars[i].weight;
                i++;
            }
            //往外出
            if(i<cars.length&&curW+cars[i].weight>w&&!queue.isEmpty()){
                car c=queue.poll();
                curW-=c.weight;
                timebias=c.endTime;
                while(!queue.isEmpty()&&queue.peek().endTime==timebias){
                    car c1=queue.poll();
                    curW-=c1.weight;
                }
            }
        }
        int maxTime=0;
        while(!queue.isEmpty()){
            maxTime=Math.max(queue.poll().endTime,maxTime);
        }
        System.out.println(maxTime);
        return maxTime;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        car[] cars=new car[n];
        int[] weight=new int[n];
        int[] times=new int[n];
        for(int i=0;i<n;i++){
            weight[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            times[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            cars[i]=new car(weight[i],times[i]);
        }
      //  System.out.println(Arrays.toString(cars));
        getTime(cars,w);
    }
}
