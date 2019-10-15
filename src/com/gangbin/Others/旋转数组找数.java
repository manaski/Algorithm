package com.gangbin.Others;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/14
 */
public class 旋转数组找数 {
    public static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target&&nums[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[mid]<target&&nums[high]>=target){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
    public static int findNum(int[] arr, int num){
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==num){
                return mid;
            }
            if(arr[low]==arr[mid]&&arr[mid]==arr[high]){//三个数字都相同时，不能判断
                while(low<mid&&arr[low]==arr[mid]){
                    low++;
                }
                if(mid==low){//左边都是一样的数字，且不是要找的数字
                    low=mid+1;
                    continue;
                }
            }
            //先找端点位置，再找数字可能的位置
            //端点在右边
            if(arr[mid]>=arr[low]){
                if(num>=arr[low]&&num<arr[mid]){
                    high=mid-1;//mid肯定不是要找的数字
                }else{
                    low=mid+1;
                }
            }else if(arr[mid]<arr[low]){ //断点在左边，右边有序
                if(arr[mid]<num&&num<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={3,1};
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ret=search(arr,n);
        System.out.println(ret);
    }
}
