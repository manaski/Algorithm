package com.gangbin.Tree.完全二叉树的节点树;

import com.gangbin.Tree.TreeNode;

/**
 * @author gangbin.li
 * @description: 完全二叉树的节点个数
 * @date 2019/8/8
 */
public class TheNumberOfNodes {
    public int nodeNum(TreeNode head){
        if(head==null){
            return 0;
        }
        return bs(head,1,mostLeftLevel(head,1));//左边肯定是最高的
    }
public int bs(TreeNode head, int level,int h){
        if(level==h){
            return 1;
        }
        if(mostLeftLevel(head.right,level+1)==h){
            return (1<<(h-level))+bs(head.right,level+1,h); //如果右节点可以到达树的高度，说明左子树是满的
        }else{
            return (1<<(h-1-level))+bs(head.left,level+1,h);//如果右节点不能到达树的高度，说明右子树是满的
        }
}
    /**
     * 获得node高度
     * @param node
     * @param level
     * @return
     */
    public int mostLeftLevel(TreeNode node, int level){
        while(node!=null){
            level++;
            node=node.left;
        }
        return level-1;
    }

}
