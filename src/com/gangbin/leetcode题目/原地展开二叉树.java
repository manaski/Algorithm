package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 原地展开二叉树 {
    public void flatten(TreeNode root) {
        process(root);
    }
    public TreeNode process(TreeNode root) {//返回最后一个节点
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode left=root.left;
        root.left=null;
        TreeNode right=root.right;
        root.right=null;
        TreeNode p=root;
        if(left!=null){
            p.right=left;
            p=process(left);
        }
        if(right!=null){
            p.right=right;
            p=process(right);
        }
        return p;
    }
}
