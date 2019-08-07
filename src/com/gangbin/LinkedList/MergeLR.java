package com.gangbin.LinkedList;

/**
 * 按照左右分区重新组合单链表
 */
public class MergeLR {
    public static Node mergelR(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head;
        int count=1;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            count++;
        }
        if(fast.next!=null){    //说明是偶数个
            slow=slow.next;
        }else{
            count--;//记录一半的长度
        }
        Node l=head;
        Node r=slow;
        Node temp=new Node(-1);
        Node newHead=temp;
        while(count-->0){
            temp.next=l;
            l=l.next;
            temp=temp.next;
            temp.next=r;
            temp=temp.next;
            r=r.next;
        }
        return newHead.next;
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
      //  node6.next=node7;
        Node q=mergelR(node);
        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }

    }
}
