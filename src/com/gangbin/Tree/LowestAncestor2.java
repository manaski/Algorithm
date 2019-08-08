package com.gangbin.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author gangbin.li
 * @description: 当查询比较多时，减少每次查询所花费时间
 * @date 2019/8/8
 */
public class LowestAncestor2 {
    private HashMap<TreeNode,TreeNode> map;
    public void record(TreeNode head){
        map=new HashMap<>();
        if(head!=null){
            map.put(head,null);//头结点父节点为null
        }
       getRecord(head);
    }

    /**
     * 本质前序遍历，建立完整的映射关系
     * @param head
     */
    public void getRecord(TreeNode head){
        if(head==null){
            return;
        }
        if(head.left!=null){
            map.put(head.left,head);
        }
        if(head.right!=null){
            map.put(head.right,head);
        }
        getRecord(head.left);
        getRecord(head.right);
    }

    public TreeNode query(TreeNode head,TreeNode node1,TreeNode node2){
        HashSet<TreeNode> path=new HashSet<>();
        while(map.containsKey(node1)){
            path.add(node1);
            node1=map.get(node1);//查到所有相关路径
        }
        while(!path.contains(node2)){
            node2=map.get(node2); //当不在路径上时向上查找
        }
        return node2;
    }

}
