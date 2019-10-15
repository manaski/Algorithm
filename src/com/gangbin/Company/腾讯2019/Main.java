package com.gangbin.Company.腾讯2019;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/20
 */
public class Main {
    public static boolean isGood(int n, String s){
        if(n<11){
            return false;
        }
        int ind=0;
        int len=s.length();
        while(ind<len&&s.charAt(ind)!='8'){
            ind++;
        }
        if(n-ind<11){
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.valueOf(scanner.nextLine());
        int len=0;
        String s=null;
        for(int i=0;i<n;i++){
            len=Integer.valueOf(scanner.nextLine());
            s=scanner.nextLine();
            if(isGood(len,s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
