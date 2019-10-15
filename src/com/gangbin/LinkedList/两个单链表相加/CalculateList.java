package com.gangbin.LinkedList.两个单链表相加;

import com.gangbin.LinkedList.Node;
import com.gangbin.LinkedList.ReverseList;

/**
 * 计算两个链表代表的数字，生成新链表
 * 方法：
 * 1、遍历生成两个数字，然后相加，然后每一位生成一个节点，用int可能会溢出，但是比较简单
 * 2、用额外空间，用两个栈把原来链表的节点逆序记录，然后计算结果，这种比较保险
 * 3、不用额外空间，用逆序函数把两个链表都逆序一下，然后按位计算，得到结果，最后要再逆序恢复
 *    由于需要对两个链表进行操作，因此必须是不同的对象
 */
public class CalculateList {
    public static Node getSum(Node node1, Node node2){
        Node p1= ReverseList.reverse(node1);
        Node p2=ReverseList.reverse(node2);
        Node tail1=p1,tail2=p2;
        Node head=new Node(-1);
        Node h=head;
        int carry=0;
        int quot=0;
        while(p1!=null||p2!=null){
            if(p1!=null&&p2!=null){
                quot=(p1.value+p2.value+carry)%10;
                carry=(p1.value+p2.value+carry)/10;
                p1=p1.next;
                p2=p2.next;
            }else if(p1!=null){
                quot=(p1.value+carry)%10;
                carry=(p1.value+carry)/10;
                p1=p1.next;
            }else {
                quot=(p2.value+carry)%10;
                carry=(p2.value+carry)/10;
                p2=p2.next;
            }
            head.next=new Node(quot);
            head=head.next;

        }
        if(carry>0){
            head.next=new Node(carry);
            head=head.next;
        }
        Node res=ReverseList.reverse(h.next);
        return res;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        Node node4=new Node(5);
        Node node5=new Node(6);
        Node node6=new Node(7);
        Node node7=new Node(8);
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;

        Node p=node;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }
        System.out.println("---------------");
        Node q=getSum(node,node4);
        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }
    }

}
