package com.gangbin.Company.猿辅导;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/24
 */
public class Main1 {

public static void getArr(int[] arr,int m){
    HashMap<Integer,Integer> map=new HashMap<>();
    int len=arr.length;
    for(int i=0;i<len;i++){
        if(map.containsKey(arr[i])){
            map.put(arr[i],map.get(arr[i])+1);
        }else{
            map.put(arr[i],1);
        }
    }
    for(int i=0;i<len;i++){
        if(map.get(arr[i])<=m){
            System.out.print(arr[i]+" ");
        }
    }
}

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] rep=new int[n];
        for(int i=0;i<n;i++){
            rep[i]=scanner.nextInt();
        }
        getArr(rep,m);
    }
}
