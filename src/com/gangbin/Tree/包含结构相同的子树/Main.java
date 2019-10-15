package com.gangbin.Tree.包含结构相同的子树;

import com.gangbin.Tree.TreeNode;

/**
 * @author gangbin.li
 * @description: 递归方法完成
 * 或者转为字符串，用线性方式完成字符串是否是子串的判断
 * @date 2019/8/23
 */
public class Main {

    public boolean isContained(TreeNode head1,TreeNode head2){

        return check(head1,head2)||isContained(head1.left,head2)||isContained(head1.right,head2);

    }
    public boolean check(TreeNode head1, TreeNode head2){
        if(head1==null&&head2==null){
            return true;
        }
        if(head1==null&&head2!=null||head1!=null&&head2==null||head1.val!=head2.val){
            return false;
        }
        return check(head1.left,head2.left)&&check(head1.right,head2.right);
    }


}
