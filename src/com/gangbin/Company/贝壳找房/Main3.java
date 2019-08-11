package com.gangbin.Company.贝壳找房;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/10
 */
public class Main3 {
    public static int[] getLongList(int n,int[] arr){
        int[] dp=new int[n];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        dp[0]=1;
        list.add(new ArrayList<>(Arrays.asList(arr[n-1])));
        for(int i=1;i<n;i++){
            int maxP=0;
            int index=0;
            for(int j=0;i<i;j++){
                if(arr[n-1-j]>arr[n-1-i]){
                    maxP= Math.max(maxP,dp[j]);
                    index=j;
                }
                System.out.println(index);
            }
            ArrayList<Integer> alist=list.size()==0?new ArrayList<>():new ArrayList<>(list.get(index));
            alist.add(arr[n-1-i]);
            System.out.println(alist);
            list.add(new ArrayList<>(alist));
            dp[i]=maxP+1;
        }
        int index=0;
        int maxV=0;
        for(int i=0;i<n;i++){
            if(dp[i]>maxV){
                maxV=dp[i];
                index=i;
            }
        }
        ArrayList<Integer> blist=list.get(index);
        int[] ret=new int[blist.size()];
        for(int i=0;i<ret.length;i++){
            ret[i]=blist.get(i);
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] arr={5,1,6,8,2,4,5,10};
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(10));
        System.out.println(Arrays.toString(getLongList(arr.length,arr)));
    }
}
