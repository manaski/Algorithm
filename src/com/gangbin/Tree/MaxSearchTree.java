package com.gangbin.Tree;


/**
 * 最大的搜索二叉树结构
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
        record[1]= Math.min(lmin,node.val);
        record[2]= Math.max(node.val,rmax);
        if(lBST==node.left&&rBST==node.right&&node.val>lmax&&node.val<rmin){
            record[0]=lsize+rsize+1;
            return node;
        }
        record[0]=Math.max(lsize,rsize);
        return lsize>rsize?lBST:rBST;
    }



}
