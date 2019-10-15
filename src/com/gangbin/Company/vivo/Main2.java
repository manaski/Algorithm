package com.gangbin.Company.vivo;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/22
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws Exception {
//
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        solution1(n,m);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        LinkedList<Integer> list=new LinkedList<>();
        int N=input[0];
        int M=input[1];
        for(int i=0;i<N;i++){
            list.add(i+1);
        }
        int count=1;
        int index=0;
        String res="";
        while(!list.isEmpty()){
            index=(index+M-1)%N;
            res+=list.remove(index)+" ";
            N=N-1;
        }
        return res;
    }
    private static int solution1(int n,int m){
        if(n==1){
            System.out.println(1);
            return 0;
        }//ans=(ans+m)%n
        int ret=(solution1(n-1,m)+m)%n;
        System.out.println("当前有"+n+"个人"+"输出的是"+(ret+1));
        return ret;
    }
}
