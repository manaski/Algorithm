package com.gangbin.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 按层打印
 */
public class PrintByLevel {
    public static void printBylevel(TreeNode node){
        if(node==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        int sum=1;
        int level=1;
        System.out.print("level"+level+": ");
        while(!queue.isEmpty()){
            TreeNode p=queue.poll();
            System.out.print(p.val+" ");
            sum--;
            if(p.left!=null){
                queue.offer(p.left);
            }
            if(p.right!=null){
                queue.offer(p.right);
            }
            if(sum==0){
                sum=queue.size();
                if(sum>0){
                    System.out.println();
                    level++;
                    System.out.print("level"+level+": ");
                }
            }
        }
    }
    public static void printZ(TreeNode node){
        if(node==null){
            return;
        }
        int level=1;
        int sum=1;
        LinkedList<TreeNode> list=new LinkedList<>();//双端队列
        list.push(node);
        System.out.print("level"+level+": ");
        while(!list.isEmpty()){
           if(level%2==1){
             TreeNode p=list.pollLast();
               System.out.print(p.val+" ");
             if(p.left!=null){
                 list.offerFirst(p.left);
             }
               if(p.right!=null){
                   list.offerFirst(p.right);
               }
           }else{
               TreeNode p=list.pollFirst();
               System.out.print(p.val+" ");
               if(p.right!=null){
                   list.offerLast(p.right);
               }
               if(p.left!=null){
                   list.offerLast(p.left);
               }
           }
           sum--;
            if(sum==0){
                sum=list.size();
                if(sum>0){
                    System.out.println();
                    level++;
                    System.out.print("level"+level+": ");
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        node.left=node2;
        node.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node4.right=node7;
        node4.left=node8;
        printBylevel(node);
        System.out.println();
        printZ(node);

    }

}
