package com.gangbin.Tree;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 用遍历结果获得元二叉树
 * @date 2019/8/8
 */
public class ArrayToTree {
    public TreeNode preInToTree(int[] preOrder,int[] inOrder){
        if(preOrder==null||preOrder.length==0){
            return null;
        }
        if(preOrder.length==1){
            return new TreeNode(preOrder[0]);
        }
        int head=preOrder[0];
        int index=0;
        int len=inOrder.length;
        while(index<len&&inOrder[index]!=head){
            index++;
        }

        TreeNode node=new TreeNode(head);
        node.left=preInToTree(Arrays.copyOfRange(preOrder,1,index+1),
                                    Arrays.copyOfRange(inOrder,0,index));
        node.right=preInToTree(Arrays.copyOfRange(preOrder,index+1,len),
                Arrays.copyOfRange(inOrder,index+1,len));
        return node;
    }

    /**
     * 先序遍历和中序遍历可以获得二叉树
     * 可以用下标，也可以用数组复制
     * @param postOrder
     * @param inOrder
     * @return
     */
    public TreeNode postInToTree(int[] postOrder,int[] inOrder){
        if(postOrder==null||postOrder.length==0){
            return null;
        }
        if(postOrder.length==1){
            return new TreeNode(postOrder[0]);
        }
        int len=inOrder.length;
        int head=postOrder[len-1];
        int index=0;
        while(index<len&&inOrder[index]!=head){
            index++;
        }

        TreeNode node=new TreeNode(head);
        node.left=preInToTree(Arrays.copyOfRange(postOrder,0,index),
                Arrays.copyOfRange(inOrder,0,index));
        node.right=preInToTree(Arrays.copyOfRange(postOrder,index,len-1),
                Arrays.copyOfRange(inOrder,index+1,len));
       return node;
    }

    /**
     * 不是任意两个数组都可以获得唯一二叉树，只有当二叉树节点有零个或两个子节点时才可以获得
     * @param pre
     * @param post
     * @return
     */
    public TreeNode prePostToTree(int[] pre,int[] post){
        if(pre==null||pre.length==0){
            return null;
        }
        if(pre.length==1){
            return new TreeNode(pre[0]);
        }

        int len=pre.length;
        int head=pre[0];
        int index=0;
        while(index<len&&post[index]!=pre[1]){
            index++;
        }
        TreeNode node=new TreeNode(head);
        node.left=prePostToTree(Arrays.copyOfRange(pre,1,index+2),
                Arrays.copyOfRange(post,0,index+1));
        node.right=prePostToTree(Arrays.copyOfRange(pre,index+2,len),
                Arrays.copyOfRange(post,index+1,len-1));
        return node;
    }


}
