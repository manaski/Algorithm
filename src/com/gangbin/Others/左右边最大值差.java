package com.gangbin.Others;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
public class 左右边最大值差 {
    public static int getMax(int[] arr){
        int len=arr.length;
        int[] left=new int[len];
        int[] right=new int[len];
        left[0]=arr[0];
        right[len-1]=arr[len-1];
        for(int i=1;i<len;i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }
        for(int j=len-2;j>=0;j--){
            right[j]=Math.max(right[j+1],arr[j]);
        }
        int max=0;
        for(int i=0;i<len;i++){
            max=Math.max(Math.abs(left[i]-right[i]),max);
        }
        System.out.println(max);
        return max;
    }
    public static int getMax1(int[] arr){
        int len=arr.length;
        int max=0;
        for(int i=0;i<len;i++){
            max=Math.max(arr[i],max);
        }
        max=max-Math.min(arr[0],arr[len-1]);
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        int[] a={2,7,3,1,1};
        getMax(a);
        getMax1(a);
    }
}
