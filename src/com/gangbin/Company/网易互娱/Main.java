package com.gangbin.Company.网易互娱;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class Main {
    public static Map<Integer,Integer> res=new HashMap<>();

    public static void multi(int a, int b){
        Map<Integer,Integer> map=new HashMap<>();
        count(a,map);
        count(b,map);
        String sa=String.valueOf(a);
        String sb=String.valueOf(b);
        int mul=a*b;
        count(mul,map);
        for(int j=sb.length()-1;j>=0;j--){
            int m=sb.charAt(j)-'0';
            int mn=m*a;
            count(mn,map);
        }
        for(int i=1;i<=9;i++){
            int count=map.getOrDefault(i,0);
            map.put(i,count);
            res.put(i,res.getOrDefault(i,0)+map.get(i));
            System.out.print(count+" ");
        }
        System.out.println();
    }
    public static void count(int n,Map<Integer,Integer> map){
        while(n!=0){
            int a=n%10;
            map.put(a, map.getOrDefault(a,0)+1);
            n=n/10;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();

        for(int i=0;i<T;i++){
            int a=scanner.nextInt();
            int b= scanner.nextInt();
            multi(a,b);
        }
        int max=0;
        int num=-1;
        for(Map.Entry<Integer,Integer> e:res.entrySet()){
            if(e.getValue()>max){
                max= e.getValue();
                num=e.getKey();
            }
        }
        System.out.print(num);
    }

}
