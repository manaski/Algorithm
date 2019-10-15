package com.gangbin.leetcode题目;



/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/2
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class 将排序树转为循环双向链表 {
    Node head=null;
    Node tail=null;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        process(root);
        tail.right=head;
        head.left=tail;
        return head;
    }
    public Node process(Node root){
        if(root==null){
            return null;
        }
        process(root.left);
        if(tail!=null){
            tail.right=root;
            root.left=tail;
            tail=root;

        }else{
            head=root;
            tail=root;
        }
        process(root.right);
        return head;
    }
}
