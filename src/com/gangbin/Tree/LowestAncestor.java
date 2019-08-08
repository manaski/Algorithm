package com.gangbin.Tree;

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
    public TreeNode getLowestAncestor(TreeNode head,TreeNode node1,TreeNode node2){
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

}
