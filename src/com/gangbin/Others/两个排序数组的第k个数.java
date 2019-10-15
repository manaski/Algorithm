package com.gangbin.Others;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/10
 */
public class 两个排序数组的第k个数 {
    public static int getKth(int[] arr1,int[] arr2, int k) throws Exception {
        int len1=arr1.length;
        int len2=arr2.length;
        if(k<1||k>len1+len2){
            throw new Exception("error");
        }

       if(arr1.length==0){
           return arr2[k-1];
       }
       if(arr2.length==0){
           return arr1[k-1];
       }
       if(k==1){//当k<2时特殊处理
           return Math.min(arr1[0],arr2[0]);
       }
        int index1=-1;
        int index2=-1;

       if(len1<len2){
           index1=Math.min(k/2,len1);
           index2=k-index1;
       }else{
           index2=Math.min(k/2,len2);
           index1=k-index2;
       }
        if(index1>0&&index2>0){
            if(arr1[index1-1]==arr2[index2-1]){
                return arr1[index1-1];
            }else if(arr1[index1-1]>arr2[index2-1]){
                int[] a= Arrays.copyOfRange(arr1,0,index1);//大的包含
                int[] b= Arrays.copyOfRange(arr2,index2,len2);//小的舍去
                return getKth(a,b,k-index2);//舍去个数是小的个数
            }else{
                int[] a= Arrays.copyOfRange(arr1,index1,len1);
                int[] b= Arrays.copyOfRange(arr2,0,index2);
                return getKth(a,b,k-index1);
            }
        }else{
            if(index1==0){
                return arr2[index2-1];
            }else{
                return arr1[index1-1];
            }
        }

    }

    public static void main(String[] args) throws Exception {
//        int[] arr1={1,2};
//        int[] arr2={};
//        int ret=getKth(arr1,arr2,0);
//        System.out.println(ret);
        int i=0;
        int j=++i;
        System.out.println(j);
    }
}
