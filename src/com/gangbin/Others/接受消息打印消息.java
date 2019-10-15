package com.gangbin.Others;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/14
 */
class Node{
    Node next;
    int val;
    Node(int val){
        this.val=val;
    }
}
public class 接受消息打印消息 {

    private  HashMap<Integer,Node> headMap;
    private  HashMap<Integer,Node> tailMap;
    private  Integer lastprint;

    接受消息打印消息(){
        headMap=new HashMap<>();
        tailMap=new HashMap<>();
        lastprint=0;
    }

    public  void recieve(int n){
        if(n<1){
            return;
        }
        Node node=new Node(n);
        headMap.put(n,node);
        tailMap.put(n,node);
        if(tailMap.containsKey(n-1)){
           Node p=tailMap.get(n-1);
           p.next=node;
           tailMap.remove(n-1);
           headMap.remove(n);
        }
        if(headMap.containsKey(n+1)){
            Node p=headMap.get(n+1);
            node.next=p;
            headMap.remove(n+1);
            tailMap.remove(n);
        }
        if(headMap.containsKey(lastprint+1)){
            print();
        }
    }
    public  void print(){
        Node q=headMap.get(++lastprint);
        headMap.remove(lastprint);
        while(q!=null){
            System.out.println(q.val);
            lastprint++;
            q=q.next;
        }
        tailMap.remove(--lastprint);
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        接受消息打印消息 t=new 接受消息打印消息();
        int i=0;
        int N=10;
        while(i++<N){
            int n=sc.nextInt();
            t.recieve(n);
        }
    }
}
