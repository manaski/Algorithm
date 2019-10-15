package com.gangbin.ArrayAndMatrix;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
public class 第一个未出现正整数 {
    public static int findFirst(int [] arr){
        int left=0;
        int right=arr.length;//表示包含的数字上限

        while(left<right){
            if(arr[left]==left+1){//数字在正确的位置上
                left++;
            }else if(arr[left]<=left||arr[left]>right||arr[arr[left]-1]==arr[left]){
                //数字上限减少的情况有
                //当前数字太小，不满足>left+1，太大，超过上限，重复，最大上限减一
                arr[left]=arr[--right];
            }else{
                //上限不变，满足要求，换到正确位置上
                arr[left]=arr[arr[left]-1]^arr[left]^(arr[arr[left]-1]=arr[left]);
            }
        }
        System.out.println(left+1);
        return left+1;
    }

    public static void main(String[] args) {
        int[] arr={-1,1,2};
        findFirst(arr);
    }
}
