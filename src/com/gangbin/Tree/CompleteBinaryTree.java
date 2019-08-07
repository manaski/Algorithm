package com.gangbin.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gangbin.li
 * @description: 判断是否是一棵完全的二叉树
 * @date 2019/7/22
 */
public class CompleteBinaryTree {

    /**
     * 递归方式实现
     * @param node
     * @return boolean
     */
    public boolean isCBT(TreeNode node){
        if(node==null){
            return false;
        }
        boolean[] res=new boolean[1];
        res[0]=true;
        getHeight(node,0,res);
        return res[0];

    }
    public int getHeight(TreeNode node, int level, boolean[] res){
        if(node==null){
            return level;
        }
        if(node.left==null&&node.right==null){
            return level+1;
        }
        if(node.left!=null&&node.right!=null){
            int Hleft=getHeight(node.left,level+1,res);
            if(!res[0]){
                return level;
            }
            int Hright=getHeight(node.right,level+1,res);
            if(!res[0]){
                return level;
            }
            if(Hleft!=Hright){
                res[0]=false;
                return level;
            }
            return Hleft;
        }
        res[0]=false;
        return level;
    }

    /**
     * 用层次遍历的方法来实现
     * @param node
     * @return
     */
    public boolean isCbt(TreeNode node){
        if(node==null){
            return false;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        boolean leaf=false;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(leaf&&(cur.left!=null||cur.right!=null)||cur.left==null&&cur.right!=null||cur.right==null&&cur.left!=null){
                return false;
            }
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
            if(cur.left==null&&cur.right==null){
                leaf=true;
            }
        }

        return true;
    }
}
