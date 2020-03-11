package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/24
 */
public class 链表相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode p=head;
        int var=0;
        int sum=0;
        while(l1!=null&&l2!=null){
            sum=l1.val+l2.val+var;
            var=sum/10;
            sum=sum%10;
            p.next=new ListNode(sum);
            p=p.next;
            l1=l1.next;
            l2=l2.next;
        }
        ListNode q=null;
        if(l1==null){
            q=l2;
        }else{
            q=l1;
        }
        while(q!=null){
            sum=q.val+var;
            var=sum/10;
            sum=sum%10;
            p.next=new ListNode(sum);
            p=p.next;
            q=q.next;
        }
        if(var!=0){
            p.next=new ListNode(var);
        }
        return head.next;
    }
}
