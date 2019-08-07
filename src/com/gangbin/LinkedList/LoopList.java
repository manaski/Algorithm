package com.gangbin.LinkedList;

/**
 * 判断是否是带有环的链表，并返回第一个入环的节点
 */
public class LoopList {
    public static Node getLoopNode(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node slow=head.next;
        Node fast=head.next.next;
        while(slow!=fast){
            if(fast.next==null||fast.next.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=head;
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
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
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node4;

        Node q=getLoopNode(node);
        System.out.println(q.value);
    }
}
