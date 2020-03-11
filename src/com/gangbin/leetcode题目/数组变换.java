package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/11/2
 */
public class 数组变换 {
    public static List<Integer> transformArray(int[] arr) {
        int[] change=new int[arr.length];
        int changed= 0;
        while(true){
            changed=0;
            for(int i=1;i<arr.length-1;i++){
                if(arr[i]<arr[i-1]&&arr[i]<arr[i+1]){
                    change[i]=1;
                    changed++;
                }
                if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
                    change[i]=-1;
                    changed++;
                }
            }
            if(changed==0){
                break;
            }
            for(int i=1;i<arr.length-1;i++){
                arr[i]+=change[i];
                change[i]=0;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int t:arr){
            res.add(t);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={6,2,3,4};
        transformArray(arr);
    }
}
