package com.zuo.exercise5_string;

/**
 * 判断字符串中的字符是够只出现过一次
 * 无递归的堆排序方法
 */

import java.util.Arrays;

public class UniqueAll {
   public static  boolean isUnique(String s){
       char[] c=s.toCharArray();
       heapSort(c);
       System.out.println(Arrays.toString(c));
       for(int i=0;i<c.length-1;i++){
           if(c[i]==c[i+1]){
               return false;
           }
       }
       return true;
   }
   public static void heapSort(char[] c){
       for(int i=0;i<c.length;i++){
           heapInsert(c,i);
       }
       for(int i=c.length-1;i>0;i--){
           swap(c,0,i);
           heapify(c,0,i);
       }
   }
   //插入过程中，上游过程
   public static void heapInsert(char[] c, int i){
       int parent=0;
       while(i!=0){
           parent=(i-1)/2;
           if(c[parent]<c[i]){
               swap(c,parent,i);
               i=parent;
           }else{
               break;
           }
       }
   }
   public static void swap(char[] c,int i,int j){
       char temp=c[i];
       c[i]=c[j];
       c[j]=temp;
   }

   //下沉调整过程，从上往下
   public static void heapify(char[]c, int i,int size){
       int left=i*2+1;
       int right=i*2+2;
       int largest=i;
       while(left<size){
           //右节点可能不存在，所以先比较左节点
           if(c[left]>c[i]){
               largest=left;
           }
           if(right<size&&c[right]>c[largest]){
               largest=right;
           }
           if(largest!=i){
              swap(c,largest,i);
           }else{
               break;
           }
           i=largest;
           left=i*2+1;
           right=i*2+2;
       }
   }

    public static void main(String[] args) {
        String s="4512152798";
        boolean res=isUnique(s);
        System.out.println(res);
    }
}
