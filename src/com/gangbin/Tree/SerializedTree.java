package com.gangbin.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化
 */
public class SerializedTree {
    public String serialize(TreeNode node){
        if(node==null){
            return "#";
        }
        String s=node.val+"!";
        s=s+serialize(node.left);
        s=s+serialize(node.right);
        return s;
    }
    public TreeNode deSerialize(String s){
        String[] ss=s.split("!");
        Queue<String> queue=new LinkedList<>();//用一个结构存起来
        for(int i=0;i<ss.length;i++){
            queue.offer(ss[i]);
        }
        TreeNode node=deSerial(queue);
        return node;
    }
    public TreeNode deSerial(Queue<String> queue){
        String s=queue.poll();
        if(s=="#"){
            return null;
        }
        TreeNode head=new TreeNode(Integer.valueOf(s));
        head.left=deSerial(queue);
        head.right=deSerial(queue);
        return head;
    }
    public String serialize1(TreeNode node){
        if(node==null){
            return "";
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        StringBuilder sb=new StringBuilder();
        sb.append(node.val+"!");
        while(!queue.isEmpty()){
            TreeNode h=queue.poll();
            if(h.left!=null){
                queue.offer(h.left);
                sb.append(h.left.val+"!");
            }else{
                sb.equals("#!");
            }
            if(h.right!=null){
                queue.offer(h.right);
                sb.append(h.right.val+"!");
            }else{
                sb.equals("#!");
            }
        }
        return sb.toString();
    }
    public TreeNode deSerialize1(String s){
        if(s==null||s.equals("")){
            return null;
        }
        String[] ss=s.split("!");
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode head=new TreeNode(Integer.valueOf(ss[0]));
        queue.offer(head);
        int index=1;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(!ss[index++].equals("#")){
                TreeNode node1=new TreeNode(Integer.valueOf(ss[index-1]));
                node.left=node1;
                queue.offer(node1);

            }
            if(!ss[index++].equals("#")){
                TreeNode node1=new TreeNode(Integer.valueOf(ss[index-1]));
                node.right=node1;
                queue.offer(node1);
            }
        }
        return head;
    }
}

