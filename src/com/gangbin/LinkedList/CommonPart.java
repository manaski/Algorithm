package com.gangbin.LinkedList;

/**
 * 打印两个有序链表的公共部分
 */
public class CommonPart {
    public void getCommonPart(Node node1,Node node2){
        if(node1==null||node2==null){
            return;
        }
        Node p1=node1;
        Node p2=node2;

        while(p1!=null&&p2!=null){
            if(p1.value>p2.value){
                p2=p2.next;
            }else if(p1.value<p2.value){
                p1=p1.next;
            }
            else {
                System.out.println(p1.value);      //相等则打印
                p1=p1.next;
                p2=p2.next;
            }
        }

    }
}
