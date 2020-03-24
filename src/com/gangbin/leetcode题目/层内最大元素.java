package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/17
 */
public class 层内最大元素 {
    //按层遍历
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int maxLevel=1;
        int maxSum=root.val;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int sum=0;
        int cnt=1;
        int level=1;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            sum+=node.val;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            cnt--;
            if(cnt==0){
                if(sum>maxSum){
                    maxSum=sum;
                    maxLevel=level;
                }
                cnt=queue.size();
                level++;
                sum=0;
            }
        }
        return maxLevel;

    }
}
