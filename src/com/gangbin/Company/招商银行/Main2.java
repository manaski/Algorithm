package com.gangbin.Company.招商银行;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
class Node{
    int u;
    List<Node> neg;
    //    Node left;
//    Node right;
    public Node(int u) {
        this.u = u;
        neg=new ArrayList<>();
    }
}
public class Main2 {
    public static void getPath(HashMap<Integer,Node> map, int n, int[][] val){
        if(map.isEmpty()){
            return;
        }
        int[] visit=new int[n];
        getMaxPath(map.get(1),val,visit);
        for(int i=0;i<n-1;i++){
            System.out.print(visit[i]+" ");
        }
        System.out.println(visit[n-1]);
    }
    public static int getMaxPath(Node head,int[][] val,int[]visit){
        LinkedList<Node> queue=new LinkedList<>();
        queue.addFirst(head);
        int max=0;
        while(!queue.isEmpty()){
            Node p=queue.pop();
            if(p.neg!=null&&p.neg.size()>0){
                for(Node q:p.neg){
                    int temp=0;
                    if(visit[q.u-1]!=0){
                        temp=visit[q.u-1]+val[head.u-1][q.u-1];
                    }else{
                        temp=getMaxPath(q, val,visit)+val[head.u-1][q.u-1];
                    }
                    max=Math.max(max,temp);
                    queue.add(q);
                }
            }
            visit[head.u-1]=max;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,Node>map=new HashMap<>();
        Node node1=null;
        Node node2=null;
        int[][] val=new int[n][n];//权值
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int k=sc.nextInt();
            if(u>v){
                u=v^u^(v=u);
            }
            val[u-1][v-1]=k;
            if(map.containsKey(u)){
                node1=map.get(u);
            }else{
                node1=new Node(u);
                map.put(u,node1);
            }
            if(map.containsKey(v)){
                node2=map.get(v);
            }else{
                node2=new Node(v);
                map.put(v,node2);
            }
            node1.neg.add(node2);
        }
//        for(Map.Entry<Integer,Node> p:map.entrySet()){
//            System.out.println(p.getKey()+" "+p.getValue());
//        }
        getPath(map,n,val);
    }

}
