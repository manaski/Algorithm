package com.gangbin.Company.百度;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/17
 */
public class Main2 {
    public static void goHome(HashMap<Integer,List<Integer>> map, int n){
        int level=0;
        HashSet<Integer> set=new HashSet<>();
        LinkedList<Integer> queue=new LinkedList<>();
        queue.push(1);
        set.add(1);
        int len=1;
        while(!queue.isEmpty()&&level<2){
            Integer node=queue.poll();
            len--;
            List<Integer> list=map.get(node);
            if(list==null){
                System.out.println("IMPOSSIBLE");
                return;
            }
            for(Integer t:list){
                if(t==n){
                    System.out.println("POSSIBLE");
                    return;
                }
                if(!set.contains(t)){
                    queue.offer(t);
                    set.add(t);
                }
            }
            if(len==0){
                len=queue.size();
                level++;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        int n=0;
        int m=0;
        int u=0;
        int v=0;
        HashMap<Integer, List<Integer>> map=null;
        for(int i=0;i<T;i++){
            n= scanner.nextInt();
            m= scanner.nextInt();
            map=new HashMap<>();
            for(int j=0;j<m;j++){
                u=scanner.nextInt();
                v=scanner.nextInt();
                if(u>v){
                    u=v^u^(v=u);
                }
                if(map.containsKey(u)){
                    if(!map.get(u).contains(v))
                        map.get(u).add(v);
                }else{
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(v);
                    map.put(u,temp);
                }
            }
            goHome(map,n);
        }
    }
}
