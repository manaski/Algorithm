package com.gangbin.Company.贝壳找房;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/10
 */
public class Main4 {
    public static long getMinIncre(int n, int[] arr){
        if(n<2){
            return 0;
        }
        if(n==2){
            return arr[0]==arr[1]?1:0;
        }
        int[] brr=null;
        long ret=0;
        long minV=Long.MAX_VALUE;
        for(int i=0;i<=n;i++){
            ret=0;
            brr= Arrays.copyOf(arr,arr.length);
            for(int j=0;j<i-1;j++){
                if(ret>minV){
                    break;
                }
                if(brr[j]>=brr[j+1]){
                    ret+=brr[j]-brr[j+1]+1;
                    brr[j+1]=brr[j]+1;
                }
            }
          //  System.out.println(Arrays.toString(brr));
            for(int k=n-1;k>i;k--){
                if(ret>minV){
                    break;
                }
                if(brr[k]>=brr[k-1]){
                    ret+=brr[k]-brr[k-1]+1;
                    brr[k-1]=brr[k]+1;
                }
            }
            if(i>0&&i<n&&brr[i]==brr[i-1]){
                ret++;
            }
        //   System.out.println(Arrays.toString(brr));
            if(ret<minV){
                minV=ret;
            }
         //  System.out.println(minV);
        }
        return minV;
    }

    public static void main(String[] args) {
        int[] a={1,4,3,2,5};
        long ret=getMinIncre(a.length,a);
        System.out.println(ret);
    }
}
