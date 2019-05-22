package com.zuo.Excercise_2_LinkedList;

/**
 *实现部分链表的翻转
 * 主要是找到翻转部分的前一个节点和后一个节点
 * 前一个节点有可能是空，额外构造一个，最后一个可能是空，用next获得
 */
public class ReversePartList {
    public static Node reverse(Node head,Node tail){
        if(head==null||head.next==null){
            return head;
        }
        //三个指针完成链表的翻转
        Node pre=null;
        Node cur=head;
        Node next=cur.next;
        while(cur!=tail){
            cur.next=pre;
            pre=cur;
            cur=next;
            if(next!=null){
                next=next.next;
            }

        }
        return pre;
    }
    public static Node reversPart(Node head,int from, int to){
        if(head==null||from>=to){
            return head;
        }
        int index=1;
        Node p=head;
        Node pre=new Node(-1);
        Node pHead=pre;
        pre.next=head;
        Node tail=null;
        while(p!=null){
            if(index==from-1){
                pre=p;
            }
            if(index==to){
               tail=p.next;
               break;
            }
            p=p.next;
            index++;
        }
        if(p==null){
            return head;
        }
        Node header=pre.next;
        Node r=reverse(header, tail);
        pre.next=r;
        header.next=tail;
        return pHead.next;
    }

    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        Node p=node;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }
        System.out.println("---------------");
        Node q=reversPart(node,2,3);
        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }
    }
}
