package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/2
 */
public class 最大搜索树 {
    public int largestBSTSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max=0;
        int count=1;
        Integer pre=null;
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                if(pre==null){
                    pre=root.val;
                }else{
                    if(root.val>pre){
                        count++;
                        max=Math.max(max,count);
                    }else{
                        count=1;
                    }
                    pre=root.val;
                }
                root=root.right;
            }
        }
     return max;
    }

}
