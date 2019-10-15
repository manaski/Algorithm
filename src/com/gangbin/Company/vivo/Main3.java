package com.gangbin.Company.vivo;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/22
 */
import java.io.*;
import java.util.Arrays;

/**
 * Welcome to vivo !
 */

public class Main3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
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

    private static int solution(int[] input) {
        int sum=0;
        for(int i=0;i<input.length;i++){
            sum+=input[i];
        }
        Arrays.sort(input);
        int sum1=input[input.length-1];
        int sum2=input[input.length-2];
        for(int i=input.length-3;i>=0;i=i-2){
            if(sum1>=sum2){
                sum2+=input[i];
                if(i>=1){
                    sum1+=input[i-1];
                }
            }else{
                sum1+=input[i];
                if(i>=1) {
                    sum2 += input[i - 1];
                }
            }
        }
        return Math.abs(sum1-sum2);
    }
}
