package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
class Car{
    int pos;
    int speed;

    public Car(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}
public class 车队问题 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        Car[] cars=new Car[n];
        for(int i=0;i<n;i++){
            cars[i]=new Car(position[i],speed[i]);
        }
        Arrays.sort(cars,(o1,o2)->o2.pos-o1.pos);
        int count=0;
        double time=0;
        int index=0;
        while(index<n){
            int dist=(target-cars[index].pos);
            int spd=cars[index].speed;
            time=(double)dist/spd;
            index++;
            while(index<n&&cars[index].pos+time*cars[index].speed>=target){
                index++;
            }
            count++;
        }
        return count;
    }
}
