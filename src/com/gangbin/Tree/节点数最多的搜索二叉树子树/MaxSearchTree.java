package com.gangbin.Tree.节点数最多的搜索二叉树子树;


import com.gangbin.Tree.TreeNode;

/**
 * 节点都不一样的树种，找到节点数最多的搜索二叉树结构
 * 思路：以节点node为头节点的搜索二叉树，需要左子树的最大搜索树以node.left为头结点，
 * 右子树的最大搜索二叉树以node.right为头结点，并且左边最大值小于node,右边最小值大于node
 */
public class MaxSearchTree {
    public TreeNode getMaxTree(TreeNode node){
        if(node==null){
            return null;
        }
        int[] record=new int[3];
        return postOrder(node,record);
    }
    public TreeNode postOrder(TreeNode node, int[] record){
        if(node==null){
            record[0]=0;
            record[1]= Integer.MAX_VALUE;
            record[2]=Integer.MIN_VALUE;
            return null;
        }
        TreeNode lBST=postOrder(node.left,record);
        int lsize=record[0];
        int lmin=record[1];
        int lmax=record[2];
        TreeNode rBST=postOrder(node.right,record);
        int rsize=record[0];
        int rmin=record[1];
        int rmax=record[2];
        record[1]= Math.min(lmin,node.val);//最小值和最大值都是假设node节点为头节点的值
        record[2]= Math.max(node.val,rmax);
        if(lBST==node.left&&rBST==node.right&&node.val>lmax&&node.val<rmin){
            record[0]=lsize+rsize+1;
            return node;
        }
        record[0]=Math.max(lsize,rsize);   //大小和头结点判断
        return lsize>rsize?lBST:rBST;
    }



}
