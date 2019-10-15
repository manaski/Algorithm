package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/16
 */
public class 两两交换链表 {
    public static ListNode reverse(ListNode head,ListNode tail) {
        ListNode pre=null;
        ListNode next=null;
        ListNode cur=head;
        while(cur!=tail){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        ListNode p=pre;
        while(p!=null){
            System.out.println(p.val);
            p=p.next;

        }
        return pre;

    }
    public static ListNode swapPairs(ListNode head,int n) {
        if(n==1){
            return head;
        }
        ListNode help=new ListNode(-1);
        help.next=null;
        ListNode start=head;
        ListNode end=head;
        ListNode pre=help;
        ListNode next=null;
        int count=1;
        while(end!=null){
            if(count%n==0){
                next=end.next;
                pre.next=reverse(start,end.next);
                pre=start;
                start=next;
                end=next;
                count++;
                continue;
            }
            end=end.next;
            count++;
        }
        pre.next=start;
        return help.next;
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode res=swapPairs(head,2);
        return res;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode node1=swapPairs(node);
        while(node1!=null){
            System.out.println(node1.val);
            node1=node1.next;

        }

    }
}
