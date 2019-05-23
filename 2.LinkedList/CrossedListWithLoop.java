package com.zuo.Excercise_2_LinkedList;

/**
 * 判断两个链表是否相交
 * 注意问题：是否有环，是否相交
 * 有环的判断
 * 无环时的相交判断
 * 有环时的相交判断
 */
public class CrossedListWithLoop {
    public static Node getCrossNode(Node node1,Node node2){
        //先判断带有环，并且返回入环的点
        Node loop1=LoopList.getLoopNode(node1);
        Node loop2=LoopList.getLoopNode(node2);
       //如果都不含有环
        if(loop1==null){
            return CrossLists.getCross(node1,node2,null);
        }
        //如果含有环
        if(loop1==loop2){
            return CrossLists.getCross(node1,node2,loop1);
        }else{
            //判断是否相交
            Node p=loop1.next;
            while(p!=loop1){
                if(p==loop2){
                    return loop2;
                }
                p=p.next;
            }
            return null;
        }
    }
}
