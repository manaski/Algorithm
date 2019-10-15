package com.gangbin.Company.贝壳找房;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/23
 */
public class Main8 {
    public static int getTail(String str){
        int len = str.length();
        int [] tail = new int[len+1];
        tail[0] = -1;
        int k = -1;
        int j  = 0;
        // 构建next数组
        while (j < len ){
            if(k== -1 || str.charAt(k) == str.charAt(j)){
                tail[++j] = ++k;
            }else{
                k = tail[k];
            }
        }
        return tail[len];
    }
    public static String getGirl(int k,String str){
        int len=getTail(str);
        String subString=str.substring(len);
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        for(int i=1;i<k;i++){
            sb.append(subString);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        scanner.nextLine();
        String str=scanner.nextLine();
        System.out.println(getGirl(k,str));


    }
}
