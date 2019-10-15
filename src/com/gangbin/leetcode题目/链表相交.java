package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/28
 */
public class 链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=0;
        int len2=0;
        ListNode h1=headA;//注意保留初始位置
        ListNode h2=headB;
        while(headA!=null){
            len1++;
            headA=headA.next;
        }
        while(headB!=null){
            len2++;
            headB=headB.next;
        }
        ListNode p1=len1>len2?h1:h2;
        ListNode p2=p1==h1?h2:h1;
        int k=0;
        while(p1!=null){
            if(p1==p2){
                return p1; //在起始位置上判断，不是移动之后再判断
            }
            if(k>=Math.abs(len1-len2)){
                p2=p2.next;
            }
            p1=p1.next;
            k++;

        }
        return null;
    }
}
