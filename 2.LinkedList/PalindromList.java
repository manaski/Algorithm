package com.zuo.Excercise_2_LinkedList;

/**
 * 判断是否是回文链表
 * 时间复杂度O(n)，空间复杂度为O(1)
 * 方法1：用栈将所有节点顺序翻转，然后依次判断是否相等，空间复杂度n
 * 方法2：对1的改进，只需要保存一半的数据就可以了，用快慢指针获得一半
 * 方法3：不需要额外n的空间，采用翻转链表的方法，将后半链表进行翻转，然后判断是否相等，最后再恢复链表
 */
public class PalindromList {
    public static boolean isPalindrom(Node head){
        if(head==null||head.next==null){
            return true;
        }
        Node left=head;
        Node right=head;
        while(right.next!=null&&right.next.next!=null){
            left=left.next;
            right=right.next.next;
        }
        Node cur=left.next;
        left.next=null;
        Node pre=null;
        Node forward=cur.next;
        while(cur!=null){
            cur.next=pre;
            pre=cur;
            cur=forward;
            if(forward!=null){
                forward=forward.next;
            }
        }
        forward=pre;//记录节点
        Node h=head;
        boolean isP=true;
        while(pre!=null&&h!=null){
            if(pre.value!=h.value){
                isP=false;
                break;
            }
            pre=pre.next;
            h=h.next;
        }
        //恢复链表
        cur=forward;
        pre=null;
        forward=cur.next;
        while(cur!=null){
            cur.next=pre;
            pre=cur;
            cur=forward;
            if(forward!=null){//这里要有个判断
                forward=forward.next;
            }
        }
        left.next=pre;
        return isP==true;
    }

    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(2);
        Node node3=new Node(1);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        Node p=node;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }
        System.out.println("---------------");
        boolean res=isPalindrom(node);
        p=node;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }
        System.out.println(res);
    }
}
