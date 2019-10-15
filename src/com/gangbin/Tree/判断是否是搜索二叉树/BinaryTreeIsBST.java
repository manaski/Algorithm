package com.gangbin.Tree.判断是否是搜索二叉树;

import com.gangbin.Tree.TreeNode;

import java.util.Stack;

/**
 * @author gangbin.li
 * @date 2019/7/22
 * 中序遍历判断二叉树是否是搜索二叉树
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
                node=node.right;
            }
        }
        return true;
    }
    //不借助栈实现中序遍历,Morris
    public boolean isBst(TreeNode node){
        if(node==null){
            return false;
        }
        TreeNode cur1=node;
        TreeNode cur2=null;
        int pre=Integer.MAX_VALUE;
        while(cur1!=null){
                cur2=cur1.left;
                if(cur2!=null){//完成两个功能，加指针和去指针
                    while(cur2.right!=null&&cur2.right!=cur1){
                        cur2=cur2.right;
                    }
                    if(cur2.right==null){
                        cur2.right=cur1;
                        cur1=cur1.left;
                        continue;//只要不是在添加指针阶段，都会访问数据
                    }else{
                        cur2.right=null;
                    }
                }//当cur2==null时，表示左边已经遍历过了，开始访问当前节点cur1
            if(pre!=Integer.MAX_VALUE&&pre>cur1.val){
                return false;
            }
                pre=cur1.val;
                cur1=cur1.right;    //访问完之后进入到右边

        }
        return true;
    }

    public static void main(String[] args) {

    }

}
