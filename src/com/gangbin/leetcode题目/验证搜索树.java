package com.gangbin.leetcode题目;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/29
 */
public class 验证搜索树 {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Integer pre=null;
        LinkedList<TreeNode> stack=new LinkedList<>();
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                if(pre!=null&&root.val<=pre){
                    return false;
                }
                pre=root.val;
                root=root.right;
            }
        }
        LinkedList list=new LinkedList();
        int a=0;
        if((a=2)>4){
            System.out.println(a);
        }
        int[][] arr={{1,2}};
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);

        String s="1234";
        return true;
    }
}
