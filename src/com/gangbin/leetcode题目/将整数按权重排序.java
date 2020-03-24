package com.gangbin.leetcode题目;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/21
 */
public class 将整数按权重排序 {
    /**
     * 如果 x 是偶数，那么 x = x / 2
     * 如果 x 是奇数，那么 x = 3 * x + 1
     */
    public static int getKth(int lo, int hi, int k) {
        int[]res=new int[hi-lo+1];
        for(int i=lo;i<=hi;i++){
            res[i-lo]=getWeght(i);
        }
        System.out.println(Arrays.toString(res));
        PriorityQueue<Integer> heap=new PriorityQueue<>(k,(o1,o2)->{if(res[o2]==res[o1])
        {
           return o1-o2;
        }
        else{
            return res[o1]-res[o2];
        }
        });
        for(int i=0;i<hi-lo+1;i++){
            heap.add(i);
        }
        for(int i=0;i<k-1;i++){
            heap.poll();
        }
        return lo+heap.poll();
    }
    public static int getWeght(int n){
        if(n==1){
            return 0;
        }
        if(n%2==1){
            n=n*3+1;
        }else{
            n=n/2;
        }
        return 1+getWeght(n);
    }

    public static void main(String[] args) {
//        int res=getKth(12,15,2);
//        System.out.println(res);
        PriorityQueue<Integer> heap=new PriorityQueue<>(1,(o1,o2)->o2-o1);
        for(int i=0;i<5;i++){
            heap.add(i);
        }
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }

    }
}
