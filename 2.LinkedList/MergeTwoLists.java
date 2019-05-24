package com.zuo.Excercise_2_LinkedList;

/**
 * 合并两个有序的单链表
 */
public class MergeTwoLists {
    public static Node merge(Node node1,Node node2){
        Node help=new Node(-1);
        Node p=help;
        while(node1!=null&&node2!=null){
            if(node1.value<node2.value){
                p.next=node1;
                node1=node1.next;
            }else{
                p.next=node2;
                node2=node2.next;
            }
            p=p.next;
        }
        if(node1!=null){
            p.next=node1;
        }
        if(node2!=null){
            p.next=node2;
        }
        return help.next;
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
        //node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        Node q=merge(node,node4);

        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }

    }
}
