package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class 各种遍历二叉树的方法 {
    //非递归的前序遍历
    public void preOrder(TreeNode root){
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            System.out.println(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }
    //非递归的中序遍历
    public void inOrder(TreeNode root){
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode node =root;
        while(!stack.isEmpty()||node!=null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node =stack.pop();
                System.out.println(node.val);
                node=node.right;
            }
        }
    }

    //非递归后序遍历
    public void postOrder(TreeNode root){
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode last=root;//上一次访问节点，初始值设为root
        TreeNode cur=null;//当前要访问的值
        stack.push(root);
        while(!stack.isEmpty()){
            cur=stack.peek();
            if(cur.left!=null&&last!=cur.left&&last!=cur.right){
                stack.push(cur.left);
            }else{
                if(cur.right!=null&&last!=cur.right){
                    stack.push(cur.right);
                }else{
                    System.out.println(stack.pop().val);
                    last=cur;
                }
            }
        }
    }
}
