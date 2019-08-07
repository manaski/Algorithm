package com.gangbin.Tree;

import java.util.Stack;

/**
 * @author gangbin.li
 * @date 2019/7/22
 * 中序遍历判断二叉树是否是平衡二叉树
 */
public class BinaryTreeIsBST {
    public boolean isBST(TreeNode node){
        if(node==null){
            return false;
        }
        int pre=Integer.MAX_VALUE;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                if(pre!=Integer.MAX_VALUE&&node.val<pre){
                    return false;
                }
                pre=node.val;
            }
        }
        return true;
    }
    //不借助栈实现中序遍历
    public boolean isBst(TreeNode node){
        if(node==null){
            return false;
        }
        TreeNode cur1=node;
        TreeNode cur2=null;
        int pre=Integer.MAX_VALUE;
        while(cur1!=null){
            cur2=cur1.left;
            if(cur2!=null){
                while(cur2.right!=null&&cur2.right!=cur1){
                    cur2=cur2.right;
                }
                if(cur2.right==null){
                    cur2.right=cur1;
                    cur1=cur1.left;
                    continue;
                }else{
                    cur2.right=null;
                }
            }
            if(pre!=Integer.MAX_VALUE&&pre>cur1.val){
                return false;
            }
                pre=cur1.val;
                cur1=cur1.right;

        }
        return true;
    }

}
