package com.zuo.exercise_3_BinaryTree;

/**
 * 比较直观的打印二叉树
 */
public class PrintTree {
    public void printTree(TreeNode root){
        printT(root,0,"H",17);
    }
    public void printT(TreeNode node, int height, String h,int len){
        if(node==null){
            return;
        }
        printT(node.right,height+1,"v",len);
        String val=h+node.val+h;
        int valLen=val.length();
        int sLen=(len-valLen)/2;
        int tlen=len-valLen-sLen;
        val=getSpace(sLen)+val+getSpace(tlen);
        System.out.println(getSpace(height*len)+val);
        printT(node.left,height+1,"^",len);
    }
    public String getSpace(int len){
        StringBuilder sb=new StringBuilder();
        while(len-->0){
            sb.append(" ");
        }
        return sb.toString();
    }
}
