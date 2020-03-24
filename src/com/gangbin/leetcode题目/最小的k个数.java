package com.gangbin.leetcode题目;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/20
 */
public class 最小的k个数 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[]{};
        }
        if(k>=arr.length){
            return arr;
        }
        int cnt=0;
        PriorityQueue<Integer> heap=new PriorityQueue<>(((o1, o2) ->o2-o1 ));
        for(int i=0;i<arr.length;i++){
            if(cnt<k){
                heap.add(arr[i]);
                cnt++;
            }else{
                if(heap.peek()>arr[i]){
                    heap.poll();
                    heap.add(arr[i]);
                }
            }
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=heap.poll();
        }
        return res;
    }
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if(k==0){
            return new int[]{};
        }
        if(k>=arr.length){
            return arr;
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>(((o1, o2) ->o2-o1 ));
        for(int i=0;i<arr.length;i++){
            heap.add(arr[i]);
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=heap.poll();
        }
        return res;
    }
    public static int[] getLeastNumbers3(int[] arr, int k) {
        if(k==0){
            return new int[]{};
        }
        if(k>=arr.length){
            return arr;
        }
        Arrays.sort(arr);
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
    public static int[] getLeastNumbers4(int[] arr, int k) {
        if(k==0||arr.length==0){
            return new int[0];
        }
        if(k>=arr.length){
            return arr;
        }
        quickSort(arr,0,arr.length-1,k);
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
    public static void quickSort(int[] arr, int begin, int end, int k){
        int i=begin;
        int j=end;
        int flag=arr[begin];
        while(i<j){
            while(i<j&&arr[j]>=flag){
                j--;
            }
            while(i<j&&arr[i]<=flag){
                i++;
            }
            arr[i]=arr[j]^arr[i]^(arr[j]=arr[i]);
        }
        arr[i]=arr[begin]^arr[i]^(arr[begin]=arr[i]);
        if(i-begin+1<k){
            quickSort(arr,i+1,end,k-(i-begin+1));
        }
        if(i-begin+1>k){
            quickSort(arr,begin,i-1,k);
        }
    }

    public static void main(String[] args) {
        int[] arr={0,1,2,3,4,0,3,3,8,1,4,6,2,8,8,15,10,0,9,9,1,2,17,8,17,25,18,18,16,
                13,18,29,2,3,32,2,26,23,18,8,34,8,11,36,36,39,46,30,21,25,21,14,41,10,
                31,55,45,16,33,47,4,52,59,60,1,43,42,10,12,56,12,27,22,52,38,12,41,42,
                71,5,42,76,8,3,31,65,11,29,28,68,33,50,73,87,22,68,31,1,38,89};
      //  quickSort(arr,0,arr.length-1);

      //  int[] res=getLeastNumbers4(arr,60);
        System.out.println(Arrays.toString(arr));
        int a=1;
        int b=2;
        a=b^a^(b=a);

    }
}
