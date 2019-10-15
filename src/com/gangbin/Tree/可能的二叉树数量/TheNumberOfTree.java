package com.gangbin.Tree.可能的二叉树数量;

import com.gangbin.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 统计可能的二叉树个数
 * @date 2019/8/8
 */
public class TheNumberOfTree {
    public static int getNumber(int N){
        int[] num=new int[N+1];
        num[0]=1;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<i+1;j++){
                num[i]+=num[j-1]*num[i-j];
            }
        }
        return num[N];
    }

    public List<TreeNode> generateTree(int n){
        return generate(1,n);
    }
    public List<TreeNode> generate(int start,int end){
        List<TreeNode> list=new ArrayList<>();
        if(start>end){
            return list;
        }
        for(int i=start;i<=end;i++){
            TreeNode node=new TreeNode(i);
            List<TreeNode> lTree=generate(start,i-1);
            List<TreeNode> rTree=generate(i+1,end);
            for(TreeNode p:lTree){
                for(TreeNode q:rTree){
                    node.left=p;
                    node.right=q;
                    list.add(cloneNode(node));
                }
            }
        }
        return list;
    }

    /**
     * 最后返回M棵树，都需要是不同的实体
     * @param node
     * @return
     */
    public TreeNode cloneNode(TreeNode node){
        TreeNode head=new TreeNode(node.val);
        head.left=cloneNode(node.left);
        head.right=cloneNode(node.right);
        return head;
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(getNumber(n));
        List<TreeNode> node=new TheNumberOfTree().generateTree(n);

    }

}
