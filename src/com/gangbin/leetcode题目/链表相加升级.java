package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/24
 */
public class 链表相加升级 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> list1=new LinkedList<>();
        LinkedList<ListNode> list2=new LinkedList<>();
        int var=0;
        int sum=0;

        while(l1!=null){
            list1.add(l1);
            l1=l1.next;
        }
        while(l2!=null){
            list2.add(l2);
            l2=l2.next;
        }
        ListNode p=null;
        ListNode node=null;
        while(!list1.isEmpty()&&!list2.isEmpty()){
            sum=list1.pop().val+list2.pop().val+var;
            var=sum/10;
            sum=sum%10;
            node=new ListNode(sum);
            node.next=p;
            p=node;
        }
        LinkedList<ListNode> q=null;
        if(list1.isEmpty()){
            q=list2;
        }else{
            q=list1;
        }
        while(!q.isEmpty()){
            sum=q.pop().val+var;
            var=sum/10;
            sum=sum%10;
            node=new ListNode(sum);
            node.next=p;
            p=node;
        }
        if(var!=0){
            node=new ListNode(var);
            node.next=p;
            p=node;
        }
        return p;
    }
}
