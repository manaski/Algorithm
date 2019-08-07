package com.gangbin.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除无序链表中重复出现的节点
 * 注意点：在基于原链表构建新链表的过程中，可能会出现需要把原链表的指针清零的操作，这也影响到最后的结果
 * 比如说，在翻转部分链表时，pre记录的上次最后一个链表的指针需要清零，在删除重复节点时，pre节点的指针同样需要删掉，以防止后面的节点
 * 不需要而被连接
 */
public class DeleteRep {
    public static Node deleteRep(Node head){
        if(head==null){
            return head;
        }
        Set<Integer> set=new HashSet<>();
        set.add(head.value);
        Node h=head.next;
        Node pre=head;
        pre.next=null;
        while(h!=null){
            if(set.contains(h.value)){
                int v=h.value;
                while(h!=null&&h.value==v){
                    h=h.next;
                }
            }else{
                set.add(h.value);
                pre.next=h;
                pre=h;
                h=h.next;
                pre.next=null;//为了避免原来的链表的影响，把next指针消除
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(1);
        Node node4=new Node(5);
        Node node5=new Node(3);
        Node node6=new Node(2);
        Node node7=new Node(1);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        Node q=deleteRep(node);
        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }

    }
}
