package com.gangbin.字节跳动;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
public class Main2 {
    public static long getTime(int[] time, int[] file){
        int t=0;
        int init=time[0];
        int count=0;
        int len=time.length;
        long[] end=new long[len+1];
        end[0]=-1;
        long start=-1;
        for(int i=0;i<time.length;i++){
            if(time[i]>end[i]){
                start=time[i];
            }else{
                start=end[i];
            }
            end[i+1]=start+file[i];
        }
        System.out.print(end[len]+" ");
        long c=getCount(time,end,file);
        System.out.print(c);
        return end[len];
    }
    public static long getCount(int[] time, long[] end,int[] file){
        int count=0;
        int len=time.length;
        int max=0;
        long d=end[len];
        for(int i=time[0];i<=d;i++){
            count=0;
            for(int j=0;j<time.length;j++){
                if(time[j]<i&&i<end[j+1]){
                    count+=file[j];
                }
            }
            max=Math.max(max,count);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] time=new int[n];
        int[] file=new int[n];
        for(int i=0;i<n;i++){
            time[i]=sc.nextInt();
            file[i]=sc.nextInt();
        }
        getTime(time,file);


    }
}
