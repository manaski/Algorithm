package com.gangbin.Tree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }

    public void setVal(int val){
        this.val=val;
    }

    public void setChild(TreeNode left, TreeNode right){
        this.left=left;
        this.right=right;
    }
}
