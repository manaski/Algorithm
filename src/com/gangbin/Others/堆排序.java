package com.gangbin.Others;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/10
 */
public class 堆排序 {
    //建堆的过程
    public static void insert(int[] arr,int index){
        int parent=0;
        while(index!=0){
            parent=(index-1)/2;
            if(arr[parent]>arr[index]){
                swap(arr,parent,index);
            }
            index=parent;
        }
    }
    //建堆是从下往上
    public static void buildHeap(int[] arr){
        for(int i=1;i<arr.length;i++){
            insert(arr,i);
        }
        System.out.println(Arrays.toString(arr));
    }


    //交换
    public static void swap(int[] arr, int i, int j){
        arr[i]=(arr[i]^arr[j]^(arr[j]=arr[i]));
    }

    //调整堆是从上往下
    public static void adjust(int[] arr, int index,int size){
        int left=index*2+1;
        int right=index*2+2;
        int smallest=index;
        while(left<size){
            if(arr[left]<arr[smallest]){
                smallest=left;
            }
            if(right<size&&arr[right]<arr[smallest]){
                smallest=right;
            }
            if(index!= smallest){
                swap(arr,index,smallest);
            }else{
                break;
            }
            index=smallest;
            left=index*2+1;
            right=index*2+2;
        }
    }
    //从大到小打印
    public static void print(int[] arr){
        int size=arr.length;
        int index=0;
        while(size>0){
            swap(arr,0,size-1);
            size--;
            adjust(arr,0,size);
        }
        System.out.print(Arrays.toString(arr));
    }

    //小顶堆插入一个数
    public static void  add(int[] arr, int val){
        if(arr[0]>=val){
            return;
        }else{
            arr[0]=val;
            adjust(arr, 0, val);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr={10,1,8,2,6,7,4,0};
        buildHeap(arr);
        add(arr,5);
        print(arr);
        //System.out.println(Arrays.toString(arr));

    }
}
