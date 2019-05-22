package com.zuo.Excercise_2_LinkedList;

/**
 * 删除倒数第k个节点
 * 两次遍历法
 * 两个指针法
 */
public class DeleteTheKthNode {
    public static Node deleteK(Node head,int k){
        if(head==null||k<=0){
            return head;
        }
        k=k+1;
        Node help=new Node(-1);
        Node fast=help;
        Node slow=help;
        help.next=head;
        //最后是在null处停下，所以k要多加一个
        while(fast!=null){
            fast=fast.next;
            k--;
            if(k<0){
              slow=slow.next;
            }
        }

       if(k==0){
            help.next=head.next;
        }else if(k<0){
            slow.next=slow.next.next;
        }
        return help.next;
    }
    //两次循环
    public static Node removek(Node head,int k){
        Node cur=head;
        //K-N
        while(cur!=null){
            k--;
            cur=cur.next;
        }
        if(k==0){
            head=head.next;
        }
        //N-K
        if(k<0){
            cur=head;
            while(++k!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        Node p=node;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }
        System.out.println("---------------");
        Node q=removek(node,2);
        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }
    }

}
