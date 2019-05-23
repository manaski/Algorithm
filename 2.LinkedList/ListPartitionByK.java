package com.zuo.Excercise_2_LinkedList;

/**
 * 给定一个标准值，将链表分为三部分，分别小于等于大于
 */
public class ListPartitionByK {
    public static Node listPartition(Node head,int k){
        Node less=new Node(-1);
        Node great=new Node(-1);
        Node equal=new Node(-1);
        Node l=less;
        Node g=great;
        Node e=equal;
        while(head!=null){
            if(head.value>k){
                g.next=head;
                g=g.next;
            }else if(head.value<k){
                l.next=head;
                l=l.next;
            }else {
                e.next=head;
                e=e.next;
            }
            head=head.next;
        }
        l.next=null;
        e.next=null;
        g.next=null;
        //注意顺序，从后往前连接
        e.next=great.next;
        l.next=equal.next;
        return less.next;
    }

    public static void main(String[] args) {
        Node node=new Node(4);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(1);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        Node p=node;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }
        System.out.println("---------------");
        Node res=listPartition(node,2);
        p=res;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }

    }

}
