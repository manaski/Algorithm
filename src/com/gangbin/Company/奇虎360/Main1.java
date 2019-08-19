package com.gangbin.Company.奇虎360;

import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * @author gangbin.li
 * @description: 重排列
 * @date 2019/8/15
 */
public class Main1 {
    public static void swap(int[] a,int i,int j){
    int temp=a[i];
    a[i]=a[j];
    a[j]=temp;
    }
    public static void getSum(int m, int n, int[] arr1,int[] arr2){
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2)->o2-o1);
        int max;
        int maxidx=-1;
        for(int i=0;i<n;i++){
            max=-1;
            for(int j=i;j<n;j++){
                if((arr2[j]+arr1[i])%m>max){
                    max=(arr2[j]+arr1[i])%m;
                    maxidx=j;
                }
            }
            queue.add(max);
            swap(arr2,i, maxidx);
        }
        while(!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }
    public static void main(String[] args) {
//        int[] a={4,4,1,1,1};
//        int[] b={4,3,0,1,2};
        int[] a={3,1,5,2,8,7,9};
        int[] b={4,4,6,7,3,1,5};
        getSum(10,7,a,b);
    }
}
