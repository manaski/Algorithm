package com.gangbin.Tree.找到最近公共祖先;

import com.gangbin.Tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gangbin.li
 * @description: 找到两个节点的最近祖先节点
 * @date 2019/8/8
 */
public class LowestAncestor {
    /**
     * 转换为后序遍历问题，当左右子树找到了两个节点时，当前根节点就是最近的公共祖先
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode getLowestAncestor(TreeNode head, TreeNode node1, TreeNode node2){
        if(head==null||head==node1||head==node2){
            return head;
        }
        TreeNode leftNode=getLowestAncestor(head.left,node1,node2);
        TreeNode rightNode=getLowestAncestor(head.right,node1,node2);
        if(leftNode!=null&&rightNode!=null){
            return head;
        }
        return leftNode!=null?leftNode:rightNode;
    }

    private HashMap<TreeNode,TreeNode> map;

    public void setMap(TreeNode node){
        if(node==null){
            return ;
        }
        if(node.left!=null){
            map.put(node.left,node);
        }
        if(node.right!=null){
            map.put(node.right,node);
        }
        setMap(node.left);
        setMap(node.right);
    }

    public TreeNode query(TreeNode node1,TreeNode node2){
        Set<TreeNode> set=new HashSet<>();
        while(map.containsKey(node1)){
            set.add(node1);
            node1=map.get(node1);
        }
        while(!set.contains(node2)){
            node2=map.get(node2);
        }
        return node2;
    }

    public TreeNode getAncestor(TreeNode head,TreeNode node1,TreeNode node2){
        map=new HashMap<>();
        if(head!=null){
            map.put(head,null);
        }
        setMap(head);
       return query(node1,node2);
    }
}
