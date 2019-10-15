package com.gangbin.Company.猿辅导;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/24
 */
public class Main2 {
    //交换位置
    public static int getCount(int n,int[] arr){
        if(n<2||arr==null){
            return 0;
        }
        Arrays.sort(arr);
        if(arr[0]<0){
            return 0;
        }
        int index=n-1;
        int inx=0;
        int count=0;
        while(arr[index]>0&&arr[index-1]>0&&arr[index-2]>0){
            count+=arr[index-2];
            arr[index]-=arr[index-2];
            arr[index-1]-=arr[index-2];
            arr[index-2]=0;
            Arrays.sort(arr);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        String Ns=scanner.nextLine();
        N=Integer.valueOf(Ns);
        int n;
        String s;
        String[] ss;
        int[] arr;
        int[] res=new int[N];
        for(int i=0;i<N;i++){
            s=scanner.nextLine();
            ss=s.split(" ");
            n=Integer.valueOf(ss[0]);
            arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=Integer.valueOf(ss[j+1]);
            }
           res[i]= getCount(n,arr);
            System.out.println(res[i]);

        }
        for(int i=0;i<N;i++){
            System.out.println(res[i]);
        }
    }
}
