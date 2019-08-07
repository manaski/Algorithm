package com.gangbin.Tree;

import com.gangbin.config.GetTree;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * 先序中序后序遍历二叉树
 */
public class PreAndInAndPostRecur {
    //递归方法实现
    public void preOrderRecur(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }
    public void inOrderRecur(TreeNode root){
        if(root==null){
            return;
        }
        inOrderRecur(root.left);
        System.out.println(root.val);
        inOrderRecur(root.right);
    }
    public void postOrderRecur(TreeNode root){
        if(root==null){
            return;
        }
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.println(root.val);
    }
    //非递归方法实现
    //前序遍历
    public void preOrderUnRecur(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            System.out.println(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }
    //中序遍历
    public void inOrderUnRecur(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(stack!=null||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                System.out.println(root.val);
                root=root.right;
            }
        }
    }
    //后序遍历
    //方法1是用一个栈实现中右左的遍历，用另一个栈保存起来，再逆序输出
    public void postOrderUnRecur1(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        Stack<TreeNode> stack1=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            stack1.push(node);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        while(!stack1.isEmpty()){
            System.out.println(stack1.pop().val);
        }
    }
    //方法2 每次记录栈顶元素和上次访问元素
    public void postOrderUnRecur2(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode c=null;   //记录栈顶元素，表示下一个要访问的对象
        while(!stack.isEmpty()){
            c=stack.peek();
            if(c.left!=null&&root!=c.left&&root!=c.right){
                stack.push(c.left);
            }else if(c.right!=null&&root!=c.right){
                stack.push(c.right);
            }else{
                System.out.println(stack.pop().val);
                root=c;    //root表示上一次弹出并访问过的元素
            }
        }
    }
    //不需要借助栈结构完成中序遍历
    //时间复杂度O(N) 空间复杂度O(1)
public void morrisIn(TreeNode root){
        if(root==null){
            return ;
        }
         TreeNode cur1=root;
         TreeNode cur2=null;
         while(cur1!=null){
             cur2=cur1.left;    //进入左子树
             if(cur2!=null){
                 while(cur2.right!=null&&cur2.right!=cur1){
                     cur2=cur2.right;   //找到左子树最右边节点
                 }
                 if(cur2.right==null){//最右节点右指针为空
                     cur2.right=cur1;   //让右指针指向cur1
                     cur1=cur1.left;    //处理完cur1子树后，再往下到cur1的左子树重复上面过程
                     continue;
                 }else{                //如果不空闲，说明已经被设置过，这次访问是利用了新指针回到了上层，恢复
                     cur2.right=null;
                 }
             }
             System.out.println(cur1.val);   //访问中间节点
             cur1=cur1.right;   //访问右节点，回到上层节点，回到上一层的中间节点
         }
}
    //不需要借助栈结构完成先序遍历
    public void morrisPre(TreeNode root){
        if(root==null){
            return ;
        }
        TreeNode cur1=root;
        TreeNode cur2=null;
        while(cur1!=null){
            cur2=cur1.left;    //进入左子树
            if(cur2!=null){
                while(cur2.right!=null&&cur2.right!=cur1){
                    cur2=cur2.right;   //找到左子树最右边节点
                }
                if(cur2.right==null){//最右节点右指针为空
                    cur2.right=cur1;   //让右指针指向cur1
                    System.out.println(cur1.val);   //访问中间节点
                    cur1=cur1.left;    //处理完cur1子树后，再往下到cur1的左子树重复上面过程
                    continue;
                }else{                //如果不空闲，说明已经被设置过，这次访问是利用了新指针回到了上层，恢复
                    cur2.right=null;
                }
            }
            cur1=cur1.right;   //访问右节点，回到上层节点
        }
    }
    public void postOrderUnRecur(TreeNode root){
        if(root==null){
            return ;
        }
        TreeNode cur1=root;
        TreeNode cur2=null;
        while(cur1!=null){
            cur2=cur1.left;
            if(cur2!=null){
                while(cur2.right!=null&&cur2.right!=cur1){
                    cur2=cur2.right;
                }
                if(cur2.right==null){
                    cur2.right=cur1;
                    cur1=cur1.left;
                    continue;
                }else{
                    cur2.right=null;
                    printEdge(cur1.left);
                }
            }
            cur1=cur1.right;
        }
        printEdge(root);
    }
    public void printEdge(TreeNode node){
        TreeNode node1=reverseTree(node);
        TreeNode p=node1;
        while(p!=null){
            System.out.println(p.val);
            p=p.right;
        }
        reverseTree(node1);
    }
    public TreeNode reverseTree(TreeNode node){
        TreeNode cur=node;
        TreeNode pre=null;
        TreeNode next=null;
        while(cur!=null){
            next=cur.right;
            cur.right=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        TreeNode node=GetTree.getTree();

        new PreAndInAndPostRecur().postOrderUnRecur(node);
        System.out.println("--------------");
        new PreAndInAndPostRecur().preOrderRecur(node);
        System.out.println("------------------");
        new PreAndInAndPostRecur().inOrderUnRecur(node);
    }


}
