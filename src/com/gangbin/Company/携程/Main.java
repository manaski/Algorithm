package com.gangbin.Company.携程;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/4
 */
public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode p1=new ListNode(-1);
        ListNode p2=new ListNode(-1);

        ListNode s=p1;
        ListNode b=p2;

        while(head!=null)
        {
            if(head.val< m)
            {
                s.next = head;
                s = s.next;
            }
            else
            {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }
        b.next=null;
        s.next=p2.next;
        return p1.next;
    }
    /******************************结束写代码******************************/

    public static void main(String[] args){
       ListNode node=new ListNode(1);
       ListNode node2=new ListNode(4);
       ListNode node3=new ListNode(5);
       ListNode node4=new ListNode(2);
       node.next=node2;
       node2.next=node3;
       node3.next=node4;
        ListNode p=partition(node,3);
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }

    }
}
