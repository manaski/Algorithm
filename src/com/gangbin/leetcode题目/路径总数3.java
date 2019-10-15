package com.gangbin.leetcode题目;

import java.util.HashMap;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/28
 */
public class 路径总数3 {
    int count=0;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer>path=new HashMap<>();
        path.put(0, 1); //准备一个0的可能性
        process(root,sum,path,0);
        return count;
    }
    public void process(TreeNode root, int sum, HashMap<Integer,Integer>path,int p){
        if(root==null){
            return;
        }
        int s=p+root.val;
        count+=path.getOrDefault(s-sum,0);
        path.put(s,path.getOrDefault(s,0)+1);//先找到前面的可能性，再把当前路径添加进去
        process(root.left, sum, path,s);
        process(root.right,sum, path,s);
        path.put(s,path.getOrDefault(s,0)-1);
    }
}
