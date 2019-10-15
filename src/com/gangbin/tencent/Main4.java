package com.gangbin.tencent;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/19
 */
public class Main4 {
    public static void findPath(HashMap<Integer, List<Integer>> map, int s,int t,int n){
        HashSet<Integer> pathSet=new HashSet<>();
        HashSet<Integer> res=new HashSet<>();
        pathSet.add(s);
        getPath(map,pathSet,s,t,res);
        for(int i=1;i<=n;i++){
            if(!res.contains(i)){
                System.out.print(i+" ");
            }
        }
    }
    public static void getPath(HashMap<Integer,List<Integer>> map, HashSet<Integer> pathSet, int s, int t,HashSet<Integer> res){
       if(s==t){
           res.addAll(pathSet);
           return ;
       }
       List<Integer> list=map.get(s);
       if(list==null){
           return ;
       }
       for(int p:list){
           if(!pathSet.contains(p)){
               pathSet.add(p);
               getPath(map, pathSet,p,t,res);
               pathSet.remove(Integer.valueOf(p));
           }
       }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int u = 0;
        int v = 0;
        HashMap<Integer, List<Integer>> map = null;
            n = scanner.nextInt();
            m = scanner.nextInt();
            map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                if (map.containsKey(u)) {
                    if (!map.get(u).contains(v))
                        map.get(u).add(v);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(v);
                    map.put(u, temp);
                }
                if (map.containsKey(v)) {
                    if (!map.get(v).contains(u))
                        map.get(v).add(u);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    map.put(v, temp);
                }
            }
            int s= scanner.nextInt();
            int t= scanner.nextInt();
            findPath(map,s,t,n);
    }
}
