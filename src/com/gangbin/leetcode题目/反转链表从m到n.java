package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/15
 */
public class 反转链表从m到n {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p=head;
        if(head==null||head.next==null||m==n){
            return head;
        }
        ListNode pre=null;
        ListNode ppre=null;
        ListNode next=null;
        int index=1;
        while(index<m){
            pre=p;
            p=p.next;
            index++;
        }
        ListNode pm=p;
        while(index<=n){
            next=p.next;
            p.next=ppre;
            ppre=p;
            p=next;
            index++;
        }
        if(pre!=null){
            pre.next=ppre;
        }
        pm.next=p;
        return m==1?ppre:head;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

    }
}
