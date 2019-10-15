package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/10
 */
public class 消消乐 {
    public static void merge(int[] arr, int k){
        int len=arr.length;
        LinkedList<Integer> count=new LinkedList<>();
        LinkedList<Integer> num=new LinkedList<>();
       int i=0;
       int j=0;
       int cnt=0;
      while(i<arr.length&&j<arr.length){
          int n=arr[i];
          j=i+1;
          cnt=1;
          while(j<arr.length&&arr[j]==n){
              j++;
              cnt++;
          }
          if(!num.isEmpty()){
              int s=num.peek();
              if(s==n){
                  if(count.peek()+cnt>=k){
                      count.pop();
                      num.pop();
                  }else{
                      int r=count.pop()+cnt;
                      count.push(r);
                  }
              }else{
                  if(cnt<k){
                      num.push(n);
                      count.push(cnt);
                  }

              }
          }else{
              if(cnt<k){
                  num.push(n);
                  count.push(cnt);
              }
          }
          i=j;
      }
      StringBuilder sb=new StringBuilder();
      while(!num.isEmpty()){
          int n=num.pop();
          int c=count.pop();
          for(int m=0;m<c;m++){
              sb.append(n);
          }
      }
        System.out.println(sb.reverse().toString());
    }

    public static void main(String[] args) {
        int[]arr={1,2,3,3,3,2,2};
        merge(arr,2);
    }
}
