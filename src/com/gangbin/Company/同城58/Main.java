package com.gangbin.Company.同城58;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/12
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String[] ss=s.split(",");
        int count=0;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<ss.length;i++){
            if(!map.containsKey(ss[i])){
                map.put(ss[i],1);
            }
        }
        for(Map.Entry<String,Integer> e:map.entrySet()){
                count++;
        }
        System.out.println(count);
    }
}
