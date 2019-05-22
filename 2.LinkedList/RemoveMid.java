package com.zuo.Excercise_2_LinkedList;

/**
 * 删除中间节点
 *一次循环，快慢指针
 * 两次循环，先得到链表长度，再找到中间
 */
public class RemoveMid {
    public Node removeMid(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node p=head;
        Node q=head.next.next;
        //注意判断条件，只有两个位置都可以移动时，p才会移动
        while(q.next!=null&&q.next.next!=null){
            p=p.next;
            q=q.next.next;
        }
        p.next=p.next.next;
        return head;
    }
}
