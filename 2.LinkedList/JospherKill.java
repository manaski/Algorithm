package com.zuo.Excercise_2_LinkedList;

/**
 * 环形队列，报数轮流杀死
 * 关键是找到新旧下标的关系式
 * 首先有     B=(A-1)%i+1
 *           old=(new+s-1)%i+1
 *        --->   old=(new+m-1)%i+1
 */
public class JospherKill {
    public static Node getSurvivor(Node head,int m){
        int len=1;
        Node last=head;
        while(last.next!=head){
            len++;
            last=last.next;
        }
        int index=getSurvive(len,m);
        while(--index>0){
            head=head.next;
        }
        head.next=head;
        return head;
    }
    public static int getSurvive(int n,int m){
        if(n==1){
            return 1;
        }
        return (getSurvive(n-1,m)+m-1)%n+1;
    }

    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node;
        Node p= getSurvivor(node,2);
        System.out.println(p.value);

    }
}
