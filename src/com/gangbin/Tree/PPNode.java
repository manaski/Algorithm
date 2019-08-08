package com.gangbin.Tree;

/**
 * @author gangbin.li
 * @description: 有父节点指针的Node
 * @date 2019/8/8
 */
public class PPNode {
    public PPNode left;
    public PPNode right;
    public PPNode parent;
    public int val;

    public PPNode(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
        this.parent=null;
    }
}
