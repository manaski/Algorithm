package com.gangbin.Company.携程;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/5
 */
public class Main4 extends Main3 {
    public static int binarySearch(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        int mid=0;
        while(start<=end){
            mid=start+((end-start)>>1);
            if(arr[mid]>=target){
                end=mid-1;
            }
            if(arr[mid]<target){
                start=mid+1;
            }
        }
        if(arr[start]==target){
            return start;
        }
        return -1;

    }
    public static void main(String[] args) {
        int[] arr={1,2,3,3,3,4,5,6,7,7,7};
        int ret=binarySearch(arr,7);
        System.out.println(ret);
        int a=4;
        int b=a+a+a>>1-1+2;
        System.out.println(a);
        System.out.println(b);

    }

}
