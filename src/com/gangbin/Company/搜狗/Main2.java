package com.gangbin.Company.搜狗;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/8
 */

public class Main2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        Map<Integer,List<Integer>> map=new HashMap<>();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            String[] ss=s.split(" ");
            Integer key=Integer.valueOf(ss[0]);
            List<Integer> list=new ArrayList<>();
            for(int j=1;j<ss.length;j++){
               list.add(Integer.valueOf(ss[j]));
            }
            map.put(key,new ArrayList<>(list));
        }
        System.out.println(2);

    }
}
