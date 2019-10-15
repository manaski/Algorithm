package com.gangbin.Tree.二叉树中的最大距离;

import com.gangbin.Tree.TreeNode;
import com.gangbin.config.GetTree;

/**
 * @author gangbin.li
 * @description: 求二叉树上节点之间最大距离
 * @date 2019/8/8
 */
public class LargestDistance {

    public int maxDistance(TreeNode node){
        int [] record=new int[1];
        return postOrder(node,record);
    }
    /**
     * 递归方法，获得左边最大值，右边最大值，然后加上当前子树根节点，比较三个值的大小
     * 很多问题可以转化为二叉树遍历问题，需要好好思考
     * @param node
     * @param record
     * @return
     */
    public int postOrder(TreeNode node,int[] record){
        if(node==null){
            record[0]=0;
            return 0;
        }
        int lMax=postOrder(node.left,record);
        int maxFromLeft=record[0];
        int rMax=postOrder(node.right,record);
        int maxFromRight=record[0];
        int curNodeMax=maxFromLeft+maxFromRight+1;
        record[0]=Math.max(maxFromLeft,maxFromRight)+1;
        return Math.max(Math.max(rMax,lMax),curNodeMax);
    }

    public static void main(String[] args) {
        TreeNode node=GetTree.getTree();
        LargestDistance l=new LargestDistance();
        System.out.println(l.maxDistance(node));
    }

}
