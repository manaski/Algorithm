package com.gangbin.Company.字节跳动;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 求指定路径条数
 * @date 2019/8/11
 */
public class Main4 {
    public static void findPath(int n,Map<Integer, ArrayList<Integer>> map, int[] ret){
         int[] count=new int[n+1];
         for(int i=1;i<n;i++){
             pathCount(map,i,count,0);
         }

         for(int i=1;i<n;i++){
             ret[(i)%3]+=count[i];
         }
    }
    public static void pathCount(Map<Integer, ArrayList<Integer>> map, int start, int[] count,int length){
        if(map.containsKey(start)){
            for(Integer t:map.get(start)){
                count[length+1]++;
                pathCount(map,t,count,length+1);
            }
        }

    }

    public static void main(String[] args) {
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        for(int i=0;i<n-1;i++){
            String s=sc.nextLine();
            String[] ss=s.split(" ");
            Integer key=Integer.valueOf(ss[0]);
            Integer val=Integer.valueOf(ss[1]);
            if(map.containsKey(key)){
                map.get(key).add(val);
            }else{
                ArrayList<Integer> list=new ArrayList<>();
                list.add(val);
                map.put(key, list);
            }
        }
        int[] ret=new int[3];
        findPath(n,map,ret);
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<3;i++){
            ret[i]=ret[i]%mod;
        }
        System.out.println(ret[0]+" "+ret[1]+" "+ret[2]);

    }
}
