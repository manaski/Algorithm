package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class 二叉树最大路径和 {
    int maxPath=0;//全局变量记录最大路径
    public int maxPathSum(TreeNode root) {
        process(root);
        return maxPath;
    }
    public int process(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(process(root.left),0);
        int right=Math.max(process(root.right),0);
        int path=left+right+root.val;//遍历每个节点做头结点所能够组成的最长路径。
        maxPath=Math.max(path,maxPath);
        return Math.max(left,right)+root.val;
    }
}
