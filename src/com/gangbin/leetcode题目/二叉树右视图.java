package com.gangbin.leetcode题目;

import java.util.LinkedList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/11/1
 */
public class 二叉树右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        List<Integer> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        queue.add(root);
        int rowSize=queue.size();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            rowSize--;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            if(rowSize==0){
                res.add(node.val);
                rowSize=queue.size();
            }
        }
        return res;
    }
}
