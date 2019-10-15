package com.gangbin.ArrayAndMatrix;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/13
 */
public class 两个有序数组中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int s1=0;
         int e1=nums1.length-1;
         int s2=0;
         int e2=nums2.length-1;
         int mid1=(s1+e1)/2;
         int mid2=(s2+e2)/2;
         while(s1<=e1&&s2<=e2){
             if(mid1==mid2){
                 return nums1[mid1];
             }else{
                 if(mid1>mid2){
                     e1=mid1;
                     s2=mid2+((e2-s2+1)&1)==1?0:1;
                 }else{
                     e2=mid2;
                     s1=mid1+((e1-s1+1)&1)==1?0:1;
                 }
             }
         }
         return nums1[e1];
    }

    public static void main(String[] args) {

    }
}
