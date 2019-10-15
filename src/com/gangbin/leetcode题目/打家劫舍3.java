package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 二叉树打家劫舍,深度遍历
 * @date 2019/9/29
 */
public class 打家劫舍3 {
    public int rob(TreeNode root) {
        int[] res=dorob(root);
        return Math.max(res[0],res[1]);

    }
    public int[] dorob(TreeNode root){
        int[] res=new int[2];
        if(root==null){
            return res;
        }
        int[] left=dorob(root.left);
        int[] right=dorob(root.right);
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=root.val+left[0]+right[0];
        return res;
    }

}
