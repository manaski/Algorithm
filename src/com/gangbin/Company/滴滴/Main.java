package com.gangbin.Company.滴滴;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/27
 */
public class Main {
    /**
     * 找连续的加号
     * @param op
     * @param index
     * @return
     */
    public static void findIndex1(int[] num,char[]op, int index){
        int end=0;
        int start=index;
        for(int i=index;i<op.length;i++){
            if(op[i]=='+'){
                start=i;
                while(i<op.length&&op[i]=='+'){
                    end=i;
                    i++;
                }
                //第一个加号之后和最后一个加号之前的位置
                if(start==1){    //如果从起始位置开始的
                    start=0;
                }
                if(i==op.length){
                    end++;
                }
                System.out.println("加法"+start+" "+end);
                Arrays.sort(num,start,end);
            }
        }
    }

    public static void findIndex2(int[] num,char[]op, int index){
        int end=0;
        int start=index;
        int len=0;
        for(int i=index;i<op.length;i++){
            len=0;
            if(op[i]=='*'){
                start=i;
                end=start;
                while(i<op.length&&op[i]=='*'){
                    end=i;
                    i++;
                }
                end++;
                if(start==1||op[start-1]!='/'){
                    start--;
                }
                System.out.println("乘法"+start+" "+end);
                Arrays.sort(num,start,end);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String str=scanner.nextLine();
        String[] ss=str.split(" ");
        int[] num=new int[n];
        char[] op=new char[n];
        int index=0;

        for(int i=0;i<n;i++){
            num[i]=Integer.valueOf(ss[2*i]);
        }
        for(int i=0;i<n-1;i++){
            op[i+1]=ss[2*i+1].charAt(0);
        }
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(op));
        findIndex1(num,op,0);
        findIndex2(num,op,0);
        System.out.println(Arrays.toString(num));
    }
}
