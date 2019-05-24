package com.zuo.Excercise_2_LinkedList;

/**
 * 插入有序环形链表中
 */
public class InsertToList {
    public static Node insert(Node head,int num){
        Node node=new Node(num);
        Node pre=head;
        Node cur=head.next;
        while(cur!=head){
            if(pre.value<=num&&cur.value>num){
                pre.next=node;
                node.next=cur;
                return head;
            }
            pre=cur;
            cur=cur.next;
        }
            pre.next=node;
            node.next=head;
            return node.value>head.value?head:node;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        Node node4=new Node(5);
        Node node5=new Node(6);
        Node node6=new Node(8);
        Node node7=new Node(9);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node;
        Node q=insert(node,3);
        System.out.println(q.value);
        Node qq=q;
        q=q.next;
        while(q!=qq){
            System.out.println(q.value);
            q=q.next;
        }

    }
}
