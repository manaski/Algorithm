package com.gangbin.Tree.根据前序中序后序数组恢复搜索树;

import com.gangbin.Tree.前序中序后序遍历方法.PreAndInAndPostRecur;
import com.gangbin.Tree.TreeNode;

/**
 * @author gangbin.li
 * @description: 用遍历结果获得元二叉树
 * @date 2019/8/8
 */
public class ArrayToTree {

    public TreeNode preInToTree(int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2){
        if(start1>end1||start2>end2){
            return null;
        }
        TreeNode node=new TreeNode(preOrder[start1]);
        int index=start2;
        for(;index<=end2;index++){
            if(inOrder[index]==preOrder[start1]){
                break;
            }
        }
        node.left=preInToTree(preOrder, start1+1, index-start2+start1, inOrder, start2, index-1);
        node.right=preInToTree(preOrder, index-start2+start1+1, end1, inOrder, index+1, end2);
        return node;
    }

    /**
     * 先序遍历和中序遍历可以获得二叉树
     * 可以用下标，也可以用数组复制
     * @param postOrder
     * @param inOrder
     * @return
     */
    public TreeNode postInToTree(int[] postOrder,int start1,int end1,int[] inOrder,int start2,int end2){
        if(start1>end1||start2>end2){
            return null;
        }
        TreeNode node=new TreeNode(postOrder[end1]);
        int index=start2;
        for(;index<=end2;index++){
            if(inOrder[index]==postOrder[end1]){
                break;
            }
        }
        node.left=postInToTree(postOrder, start1, index-1-start2+start1, inOrder, start2, index-1);
        node.right=postInToTree(postOrder, index-start2+start1, end1-1, inOrder, index+1, end2);
        return node;
    }

    /**
     * 不是任意两个数组都可以获得唯一二叉树，只有当二叉树节点有零个或两个子节点时才可以获得
     */
    public TreeNode prePostToTree(int[] preOrder,int start1,int end1,int[] postOrder,int start2,int end2){
        if(start1>end1||start2>end2){
            return null;
        }
        TreeNode node=new TreeNode(preOrder[start1]);
        if(start1==end1){//这个判断很重要，避免出现下标溢出的问题
            return node;
        }
        int index=start2;
        while(start1+1<=end1&&index<=end2&&postOrder[index]!=preOrder[start1+1]){
            index++;
        }
        node.left=prePostToTree(preOrder,start1+1,index-start2+start1+1,postOrder,start2,index);
        node.right=prePostToTree(preOrder,index-start2+start1+2,end1,postOrder,index+1,end2-1);
        return node;
    }

    public static void main(String[] args) {
        int[] post={1,3,2,5,7,6,4};
        int[] pre={4,2,1,3,6,5,7};
        int[] in={1,2,3,4,5,6,7};
        ArrayToTree a=new ArrayToTree();
        TreeNode node=a.preInToTree(pre,0,pre.length-1,in,0,in.length);
        new PreAndInAndPostRecur().preOrderRecur(node);
        TreeNode node1=a.prePostToTree(pre,0,pre.length-1,post,0,post.length-1);
        new PreAndInAndPostRecur().preOrderRecur(node1);
        TreeNode node2=a.postInToTree(post,0,post.length-1,in,0,in.length-1);
        new PreAndInAndPostRecur().preOrderRecur(node2);
    }




}
