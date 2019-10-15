package com.gangbin.Company.流利说;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */
public class Main2 {
    public static int gift(int[]pathA,int[]pathB,int n, int Agoods,int Bgoods){
        int sumPath=0;
        for(int i=0;i<n;i++){
            if(Agoods>0&&Bgoods>0){
                if(pathA[i]>pathB[i]){
                    sumPath+=pathB[i];
                    Bgoods--;
                }else{
                    sumPath+=pathA[i];
                    Agoods--;
                }
            }else{
                if(Agoods==0){
                    sumPath+=pathB[i];
                    Bgoods--;
                }else{
                    sumPath+=pathA[i];
                    Agoods--;
                }
            }
        }
        return sumPath;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guest=scanner.nextInt();
        int Agoods=scanner.nextInt();
        int Bgoods=scanner.nextInt();
        int[] pathA=new int[guest];
        int[] pathB=new int[guest];
        for(int i=0;i<guest;i++){
            pathA[i]=scanner.nextInt();
            pathB[i]=scanner.nextInt();
        }

        int ret=gift(pathA,pathB,guest,Agoods,Bgoods);
        System.out.println(ret);
    }
}
