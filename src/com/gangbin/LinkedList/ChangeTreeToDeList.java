package com.gangbin.LinkedList;

/**
 * 将一个搜索二叉树转化为有序的双向链表
 * 将树中序遍历，可以得到有序的数列，将数列重新组合即可
 * 或者采用递归方法
 */
public class ChangeTreeToDeList {

    public TreeNode changeTree(TreeNode node){
        if(node==null){
            return null;
        }
        if(node.left==null&&node.right==null){
            node.right=node;
            return node;
        }
        TreeNode leftNode=changeTree(node.left);
        TreeNode rightNode=changeTree(node.right);
        if(leftNode!=null&&rightNode!=null){
            node.right=rightNode.right;
            rightNode.right.left=node;
            rightNode.right=leftNode.right;
            node.left=leftNode;
            leftNode.right=node;
            return rightNode;
        }else if(leftNode!=null){
            node.right=leftNode.right;
            leftNode.right=node;
            node.left=leftNode;
            return node;
        }else{
            node.right=rightNode.right;
            rightNode.right=node;
            node.left=rightNode;
            return rightNode;
        }


    }

}
