package com.gangbin.Company.同城58;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/12
 */
public class Main2 {
    public static int getCoockie(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int index = findnextMin(arr, 0);
        int res = calright(arr, 0, index++);
        int leftH = 1;
        int minIndx = 0;
        int cookie = 0;
        int rightH = 0;
        while (index != arr.length) {
            if (arr[index] > arr[index - 1]) {
                res += ++leftH;    //上坡时一个一个的加
                index++;           //右移
            } else if (arr[index] < arr[index - 1]) {
                minIndx = findnextMin(arr, index - 1);
                cookie = calright(arr, index - 1, minIndx++);
                rightH = minIndx - index + 1;
                if(rightH > leftH){
                    res += cookie -leftH;
                }else{
                    res += cookie-rightH;
                }
                leftH = 1;
                index = minIndx;
            } else {
                res += 1;
                leftH = 1;
                index++;
            }
        }
        return res;
    }

    public static int findnextMin(int[] arr, int start) {
        for (int i = start; i != arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }

    public static int calright(int[] arr, int left, int right) {
        int n = right - left + 1;
        return n + n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ret=getCoockie(arr);
        System.out.println(ret);

    }
}
