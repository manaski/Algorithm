package com.zuo.exercise_3_BinaryTree;

/**
 * 判断一棵二叉树是否是平衡的
 * 问题可以转化为后续遍历
 * 平衡条件：空树，每个子树都是平衡的
 * 设置全局变量，表示遍历到的子树是否是平衡的
 */
public class BalancedTree {
    public boolean isBalance(TreeNode head){
        boolean[] res=new boolean[1];
        res[0]=true;
        getHeight(head,1,res);
        return res[0];
    }
    public int getHeight(TreeNode head, int level,boolean[] res){
        if(head==null){
            return level;
        }

        int leftLevel=getHeight(head.left,level+1,res);

        if(!res[0])
        {
            return level;
        }
        int rightLevel=getHeight(head.right,level+1,res);

        if(!res[0])
        {
            return level;
        }

        if(Math.abs(leftLevel-rightLevel)>1){
            res[0]=false;
        }
        return Math.max(leftLevel,rightLevel);

    }
}
