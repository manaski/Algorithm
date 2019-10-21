package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/17
 */
public class 二叉树最近祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p==null||q.left==p||q.right==p){
            return q;
        }
        if(q==null||p.left==q||p.right==q){
            return p;
        }
        return findNode(root,p,q);
    }
    public TreeNode findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        TreeNode left=findNode(root.left, p, q);
        TreeNode right=findNode(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }
         if(root==p||root==q){
             return root;
         }
         return left==null?right:left;
    }
}
