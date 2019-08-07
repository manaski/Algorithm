package com.gangbin.LinkedList;

/**
 * 找到不存在环的两个链表的相交的位置
 * 先遍历一遍，获得两个长度，然后长的先走一段，然后同步走，如果中间有相同节点退出，如果走到尾退出
 */
public class CrossLists {
    public static Node getCross(Node node1,Node node2,Node end){
        int len1=0,len2=0;
        Node p1=node1;
        Node p2=node2;
        while(p1!=end){
            len1++;
            p1=p1.next;
        }
        while(p2!=end){
            len2++;
            p2=p2.next;
        }
        int len=0;
        p1=node1;
        p2=node2;
        if(len1>len2){
            len=len1-len2;
            while(len-->0){
                p1=p1.next;
            }
        }else if(len1<len2){
            len=len2-len1;
            while(len-->0){
                p2=p2.next;
            }
        }
        while(p1!=end&&p2!=end&&p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        Node node4=new Node(5);
        Node node5=new Node(6);
        Node node6=new Node(7);
        Node node7=new Node(8);
        node.next=node1;
        node1.next=node5;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;

        Node q=getCross(node,node2,null);
        System.out.println(q.value);
    }
}
