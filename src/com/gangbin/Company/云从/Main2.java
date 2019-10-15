package com.gangbin.Company.云从;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        s1=s1.substring(1,s1.length()-1);
        s2=s2.substring(1,s2.length()-1);
        String[]ss1=s1.split(",");
        String[]ss2=s2.split(",");
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        for(int i=0;i<ss1.length;i++){
            set.add(Integer.valueOf(ss1[i]));
        }
        for(int i=0;i<ss2.length;i++){
            set1.add(Integer.valueOf(ss2[i]));
        }
        List<Integer> list=new ArrayList<>();

        String res="[";
        for(Integer t:set1){
            if(set.contains(t)){
               list.add(t);
            }
        }
        Collections.sort(list);
        for(Integer t:list){
            res+=t+",";
        }
        if(res.length()>1){ res=res.substring(0,res.length()-1);
        }
        res+="]";
        System.out.println(res);
    }
}
