package com.gangbin.Tree.是否包含树的全部拓扑结构;

import com.gangbin.Tree.TreeNode;

/**
 * @author gangbin.li
 * @description: 一棵树包含另一棵二叉树的部分或全部结构
 * 用递归的方式，确实非常简洁，两个递归函数
 * @date 2019/8/8
 */
public class ContainsTree {
    /**
     * 遍历了所有节点，从每个节点开始都做了一次判断，时间复杂度O（NxM）
     * @param head1
     * @param head2
     * @return
     */
    public static boolean contains(TreeNode head1, TreeNode head2){
        return check(head1,head2)||contains(head1.left,head2)||contains(head1.right,head2);
    }

    public static boolean check(TreeNode head1,TreeNode head2){
        if(head2==null){
            return true;
        }//遍历完树2，说明匹配
        if(head1==null||head1.val!=head2.val){
            return false;
        }
        return check(head1.left,head2.left)&&check(head1.right,head2.right);
    }
}
