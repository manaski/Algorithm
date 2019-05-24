package com.zuo.Excercise_2_LinkedList;

import java.util.Stack;

/**
 * 每隔K个节点翻转，不足的不用翻转
 */
public class ReverseKNodes {
    public static Node reversek(Node head,int k){
        if(head==null){
            return null;
        }
        Stack<Node> stack=new Stack<>();
        int count=0;
        Node pre=null;     //记录每次翻转后的最后一个节点
        Node oldHead=head;//记录总的头部
        while(head!=null){
            stack.push(head);
            head=head.next;
            count++;
            if(count%k==0){
                Node p=stack.pop();
                Node newHead=p;     //翻转段的头部
                while(!stack.isEmpty()){
                   p.next=stack.pop();
                   p=p.next;
                }
                p.next=null;
              if(pre!=null){
                  pre.next=newHead;
                  pre=p;
              }else{
                  oldHead=newHead;
                  pre=p;
              }
            }
        }
        //没有翻转的部分接到后面
        if(stack.size()>0){
            while(stack.size()>1){
                stack.pop();
            }
            pre.next=stack.pop();
        }
        return oldHead;
    }
    public static Node reverseK2(Node head,int k){
        if(head==null){
            return null;
        }
        Node end=null;
        Node h=head;
        Node start=head;
        Node newHead=null;
        int count=0;
        while(h!=null){
            count++;
            h=h.next;
            if(count%k==0){
                int n=0;
                Node pre=null;
                Node cur=start;
                Node next=cur.next;
                while(n<k){
                    cur.next=pre;
                    pre=cur;
                    cur=next;
                    if(next!=null){
                        next=next.next;
                    }
                    n++;
                }
                if(end==null){
                    end=start;
                    newHead=pre;
                }else{
                    end.next=pre;
                    end=start;
                }
                end.next=null;
                start=cur;
            }
        }
        if(start!=null){
            end.next=start;
        }
        return newHead;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        Node node4=new Node(5);
        Node node5=new Node(6);
        Node node6=new Node(7);
        Node node7=new Node(8);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        Node q=reversek(node,3);
        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }

    }
}
