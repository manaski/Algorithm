package com.gangbin.LinkedList;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * 复制一个带有随机指针的链表
 * 两种方法
 * 1、用哈希表记录对应的复制对象，然后遍历一边分别建立和随机对象和下一个对象的关系
 * 2、将新生成的节点插入到原来的链表中，然后重新建立关系
 */
class Noder{
    public int value;
    public Noder next;
    public Noder rand;
    public Noder(int value) {
        this.value = value;
    }
}
public class CopyListWithRandomPointer {

    public static Noder copyList(Noder head){
         Map<Noder,Noder> map=new HashMap<>();
         Noder p=head;
         while(p!=null){
            map.put(p,new Noder(p.value));
            p=p.next;
         }
         p=head;
         while(p!=null){
             Noder node=map.get(p);
             if(p.next!=null)
             node.next=map.get(p.next);
             if(p.rand!=null)
             node.rand=map.get(p.rand);
         }
         return map.get(head);
    }
    public static Noder copyList2(Noder head){
        if(head==null){
            return null;
        }
        Noder p=head;
        while(p!=null){
            Noder node=new Noder(p.value);
            node.next=p.next;
            p.next=node;
            p=node.next;
        }
        p=head;
        while(p!=null){
            if(p.rand!=null){
                p.next.rand=p.rand.next;
            }
            p=p.next.next;
        }
        //拆分链表
        p=head;
        Noder nHead=p.next;
        Noder q=p.next;
        while(p!=null){
            p.next=q.next;
            p=p.next;
            if(p!=null){
                q.next=p.next;
                q=q.next;
            }
        }
        return nHead;
    }
        public static void main(String[] args) {
            Noder node=new Noder(1);
            Noder node1=new Noder(2);
            Noder node2=new Noder(3);
            Noder node3=new Noder(4);
            node.next=node1;
            node1.next=node2;
            node2.next=node3;
            node.rand=node2;
            node3.rand=node;
            Noder p=node;
            while(p!=null){
                System.out.print(p.value+" ");
                if(p.rand!=null){
                    System.out.println(p.rand.value);
                }else{
                    System.out.println();
                }
                p=p.next;
            }
            System.out.println("---------------");
            Noder q=copyList2(node);
            while(q!=null){
                System.out.print(q.value+" ");
                if(q.rand!=null){
                    System.out.println(q.rand.value);
                }else{
                    System.out.println();
                }
                q=q.next;
            }
        }


}
