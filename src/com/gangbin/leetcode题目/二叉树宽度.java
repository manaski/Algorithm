package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/26
 */
public class 二叉树宽度 {
    int maxLen=0;
    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return maxLen-1;
    }
    public int process(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 0;
        }
        int left=process(root.left);
        int right=process(root.right);
        maxLen=Math.max(left+right+1,maxLen);
        return Math.max(left,right)+1;
    }
}
