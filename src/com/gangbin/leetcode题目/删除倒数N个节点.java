package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/16
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class 删除倒数N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){return head;}

        ListNode p1=head;
        ListNode p2=head;
        int len=1;
        while(p1.next!=null){
            len++;
            p1=p1.next;
            if(len>n+1){
                p2=p2.next;
            }
        }
        if(n>len){
            return head;
        }
        if(n==len){
            return head.next;
        }
        p2.next=p2.next.next;
        return head;
    }
}
