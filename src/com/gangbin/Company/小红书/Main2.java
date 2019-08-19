package com.gangbin.Company.小红书;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/18
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String ss[]=s.split(" ");
        for(int i=ss.length-1;i>=0;i--){
            if(ss[i].length()!=0){
                System.out.print(ss[i]+" ");
            }
        }
    }
}
