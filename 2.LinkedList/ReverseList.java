package com.zuo.Excercise_2_LinkedList;

/**
 * 翻转单链表或双链表
 */
public class ReverseList {

    public static Node reverse(Node head){
        if(head==null||head.next==null){
            return head;
        }
        //三个指针完成链表的翻转
        Node pre=null;
        Node cur=head;
        Node next=cur.next;
        while(cur!=null){
            cur.next=pre;
            pre=cur;
            cur=next;
            //这个判断不要忘了
            if(next!=null){
                next=next.next;
            }

        }
        return pre;
    }
    //双向链表
    public static DeNode reverse2(DeNode head){
        if(head==null||head.next==null){
            return head;
        }
        //三个指针完成链表的翻转
        DeNode pre=null;
        DeNode cur=head;
        DeNode next=cur.next;
        while(cur!=null){
            cur.next=pre;
            cur.last=next;
            pre=cur;
            cur=next;
            if(next!=null){
                next=next.next;
            }
        }
        return pre;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
//        Node node2=new Node(3);
//        Node node3=new Node(4);
        node.next=node1;
//        node1.next=node2;
//        node2.next=node3;
        Node p=node;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }
        System.out.println("---------------");
        Node q=reverse(node);
        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }
    }
}
