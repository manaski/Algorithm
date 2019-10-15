package com.gangbin.Others;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/14
 */
public class 最小不可组成和 {
    public static int getMin(int[] arr){
        int len=arr.length;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=arr[i];
            min=Math.min(arr[i],min);
        }
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for(int i=0;i<len;i++){
            for(int j=sum;j>=arr[i];j--){
                dp[j]=dp[j-arr[i]]?true:dp[j];
            }
        }
        int index=min;
        while(index<=sum&&dp[index]){
            index++;
        }
        return index;
    }

    //如果能确定一定有一个1存在的话，可以得到优化
    public static int getMin2(int[] arr){
        int range=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=range+1){
                range+=arr[i];
            }else{
                return range+1;
            }
        }
        return range+1;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,8};
        int ret=getMin(arr);
        System.out.println(ret);
         ret=getMin2(arr);
        System.out.println(ret);
    }
}
