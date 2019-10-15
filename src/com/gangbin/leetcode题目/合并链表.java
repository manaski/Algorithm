package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/24
 */
public class 合并链表 {
    public static ListNode mergeKLists(ListNode[] lists) {
        int len=lists.length;
        return mergeKLists(lists,0,len-1);
    }
    public static ListNode mergeKLists(ListNode[] lists, int begin, int end){
        if(end<begin){
            return null;
        }
        if(end==begin){
            return lists[begin];
        }
        int mid=(begin+end)/2;
        ListNode left=mergeKLists(lists,begin,mid);
        ListNode right=mergeKLists(lists,mid+1,end);
        return mergeKLists(left,right);
    }
    public static ListNode mergeKLists(ListNode list1,ListNode list2){
        ListNode head=new ListNode(-1);
        ListNode p=head;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                p.next=list2;
                p=p.next;
                list2=list2.next;
            }else{
                p.next=list1;
                p=p.next;
                list1=list1.next;
            }
        }
        if(list1!=null){
            p.next=list1;
        }
        if(list2!=null){
            p.next=list2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        ListNode listNode2=new ListNode(4);
        listNode.next=listNode2;
        ListNode listNode3=new ListNode(2);
        ListNode listNode4=new ListNode(5);
        listNode3.next=listNode4;
//        ListNode p= mergeKLists(listNode,listNode3);
//        while (p!=null){
//            System.out.println(p.val);
//            p=p.next;
//        }
        ListNode[] a={listNode,listNode3};
        ListNode p=mergeKLists(a);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
}
