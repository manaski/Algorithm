package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/20
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode pre=slow;
        ListNode cur=slow.next;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        while(head!=pre&&head.next!=pre){
            if(head.val!=pre.val){
                return false;
            }
            head=head.next;
            pre=pre.next;
        }
        return true;
    }
}
