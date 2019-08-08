package com.gangbin.Tree;

/**
 * @author gangbin.li
 * @description: 有父指针的二叉树，找到后序节点
 * @date 2019/8/8
 */
public class NextNode {
    public PPNode getPostNode(PPNode node){
        if(node==null){
            return null;
        }
        if(node.right!=null){//如果右子树不为空，那么返回右子树最左节点
            PPNode pnode=node.right;
            while(pnode.left!=null){
                pnode=pnode.left;
            }
            return pnode;
        }else{//右子树为空，向上查找，如果为父节点左节点，返回父节点，如果为父节点右节点，继续向上
            PPNode ppNode=node.parent;
            while(ppNode!=null&&ppNode.left!=node){
                node=ppNode;
                ppNode=ppNode.parent;
            }
            return ppNode;
        }
    }
}
