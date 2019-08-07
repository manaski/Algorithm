package com.gangbin.StackAndQueue;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列方法解决这个滑动窗口问题
 * 找到数组中满足最大值最小值差的子数组个数
 * 特点：
 * 若某个子数组满足条件，则其子数组也满足条件
 * 若某个子数组不满足条件，包含这个子数组的其他子数组不满足
 */
public class MaxSubMinNum {
    public static int getSubArr(int[] arr,int num){
        Deque<Integer> queMax=new LinkedList<>();
        Deque<Integer> queMin=new LinkedList<>();
        int j=0;
        int i=0;
        int res=0;
        while(i<arr.length){
            while(j<arr.length){
                while(!queMax.isEmpty()&&arr[queMax.peekLast()]<=arr[j]){
                    queMax.pollLast();
                }
                queMax.push(j);
                while(!queMin.isEmpty()&&arr[queMin.peekLast()]>=arr[j]){
                    queMin.pollLast();
                }
                queMin.push(j);
                if(queMax.peekFirst()-queMin.peekFirst()>num){
                    break;
                }
                j++;
            }
            //当窗口起始位置发生变化时，更新头部
            if(queMax.peekFirst()==i){
                queMax.pollFirst();
            }
            if(queMin.peekFirst()==i){
                queMin.pollFirst();
            }
            res+=j-i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] b={1,2,5};
        int res=getSubArr(b,4);
        System.out.println(res);
    }

}
