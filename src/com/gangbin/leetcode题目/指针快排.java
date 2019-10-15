package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/25
 */
public class 指针快排 {
    public static ListNode sortList(ListNode head) {
        sortList(head,null);
        ListNode p=head;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
        return head;
    }
    public static void sortList(ListNode head,ListNode tail){
        if(head==tail||head.next==tail){
            return;
        }
        ListNode p=head;
        ListNode q=head.next;
        int mid=p.val;
        while(q!=tail){
            if(q.val<mid){
                p=p.next;
                swap(p,q);
            }
            q=q.next;
        }
        swap(head,p);
        sortList(head,p.next);
        sortList(p.next,tail);

    }
    public static void swap(ListNode p1,ListNode p2){
        if(p1!=null&&p2!=null){
            p1.val=p2.val^p1.val^(p2.val=p1.val);
        }
        }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        ListNode listNode2=new ListNode(4);
        listNode.next=listNode2;
        ListNode listNode3=new ListNode(2);
        ListNode listNode4=new ListNode(5);
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        sortList(listNode);

    }
}
