package com.gangbin.Company.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/22
 */

/**
 * Welcome to vivo !
 */
public class Main {

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
        int cur=0;
        int next=-1;
        int count=0;
        if(input==null||input.length==1){
            return 0;
        }
        for(int i=0;i<input.length;i++){
            if(i>cur){
                if(next<=cur){
                    return -1;
                }
                cur=next;
                count++;
            }
            next=Math.max(next,input[i]+i);
        }
        if(cur<input.length-1){
            return -1;
        }
        return count;
    }
}

