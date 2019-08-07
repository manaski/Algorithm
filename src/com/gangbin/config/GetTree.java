package com.gangbin.config;

import com.gangbin.Tree.TreeNode;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/8
 */
public class GetTree {

    public static TreeNode getTree(){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        node4.setChild(node2,node6);
        node2.setChild(node1,node3);
        node6.setChild(node5,node7);
        return node4;
    }
}
