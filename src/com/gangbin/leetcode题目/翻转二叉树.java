package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.right=invertTree(left);
        root.left=invertTree(right);
        return root;
    }
}
