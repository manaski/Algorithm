package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/2
 */
public class 最大搜索树 {
    static int count=0;
    static int res=0;
    public static int largestBSTSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(isBST(root)){
            return res;
        }else{
            return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
        }
    }
    public static boolean isBST(TreeNode root) {
        if(root==null){
            return true;
        }
        count=0;
        Integer pre=null;
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                count++;
                if(pre==null){
                    pre=root.val;
                }else{
                    if(root.val<=pre){
                       return false;
                    }
                    pre=root.val;
                }
                root=root.right;
            }
        }
        res=Math.max(res,count);
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(8);
        TreeNode node4=new TreeNode(10);
        TreeNode node5=new TreeNode(15);
        TreeNode node6=new TreeNode(7);
        node2.left=node1;
        node2.right=node3;
        node4.left=node2;
        node4.right=node5;
        node5.right=node6;
        largestBSTSubtree(node4);
    }

}
