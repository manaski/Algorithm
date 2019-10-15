package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/28
 */
public class 累加树 {
    //中序遍历
    public TreeNode convertBST(TreeNode root) {
        process(root,0);
        return root;
    }
    public int process(TreeNode root, int parent) {
        if(root==null){
            return parent;
        }
        int right=process(root.right,parent);
        root.val=right+root.val;
        int left=process(root.left,root.val);
        return left;
    }
}
