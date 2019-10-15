package com.gangbin.Others;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/14
 */
public class 旋转数组找到断点 {
    public static int findNum(int[] arr){
        int low=0;
        int high=arr.length-1;
        int mid=0;
        if(arr[low]<arr[high]){
            return low;
        }
        while(low<high){
            mid=(low+high)/2;
            if(mid==low){
                return arr[low]<arr[high]?low:high;
            }
            //先处理三个数字相等的情况
            if(arr[low]==arr[mid]&&arr[mid]==arr[high]){
                while(low<mid&&arr[low]==arr[mid]){
                    low++;
                }
                if(mid==low){
                    continue;
                }
            }
            //分别往断点所在区间移动
            if(arr[low]<=arr[mid]){
                low=mid;
            }else{
                high=mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,1,1,1};
        Scanner sc=new Scanner(System.in);
        int ret=findNum(arr);
        System.out.println(ret);
    }
}
