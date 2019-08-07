package com.gangbin.Tree;

import java.util.Arrays;

public class PostArray {
    public static boolean isPostArray(int[] arr){
        if(arr==null||arr.length==0){
            return true;
        }
        int len=arr.length;
        int posLeft=0;
        while(posLeft<len&&arr[posLeft]<arr[len-1]){
            posLeft++;
        }
        int posRight=posLeft;
        while(posRight<len&&arr[posRight]>arr[len-1]){
            posRight++;
        }
        if(posRight!=len-1){
            return false;
        }
        return isPostArray(Arrays.copyOfRange(arr,0,posLeft))&&isPostArray(Arrays.copyOfRange(arr,posLeft,posRight));
    }

    public static boolean isPost(int[] arr){
        if(arr==null||arr.length==0){
            return false;
        }
         return isPostArray(arr);

    }
    public static void main(String[] args) {
        int[] arr={2,3,1};
        System.out.println(isPost(arr));

    }

}
