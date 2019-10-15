package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/19
 */
public class 移动链表 {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int len=0;
        ListNode p=head;
        ListNode q=head;
        while(q!=null){
            len++;
            q=q.next;
            if(len>k+1){
                p=p.next;
            }
        }
        System.out.println(p.val);
        return p;
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
        rotateRight(node1,2);
    }
}
