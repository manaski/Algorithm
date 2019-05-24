package com.zuo.Excercise_2_LinkedList;

/**
 * 删除具有指定值的节点
 */
public class DeleteNodeK {
    public static Node deleteNodeK(Node head, int k){
        if(head==null){
            return null;
        }
        Node p=null;
        Node h=head;
        while(h!=null){
            if(h.value==k){
                while(h!=null&&h.value==k){
                    h=h.next;
                }
                if(h==null){
                    break;
                }
            }
                if(p==null){
                    p=h;
                    head=p;
                    h=h.next;
                    p.next=null;
                }else{
                    p.next=h;
                    p=h;
                    h=h.next;//这里注意顺序，注意提前把指针移走，再把pre指针清零
                    p.next=null;
                }
        }
       return head;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(1);
        Node node4=new Node(5);
        Node node5=new Node(3);
        Node node6=new Node(1);
        Node node7=new Node(1);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        Node q=deleteNodeK(node,1);
        while(q!=null){
            System.out.println(q.value);
            q=q.next;
        }

    }

}
