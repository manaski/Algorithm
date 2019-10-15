package com.gangbin.Tree.是否是搜索树的后序数组及恢复搜索二叉树;

import com.gangbin.Tree.TreeNode;

import java.util.Arrays;

public class PostArray {
    /**
     * 判断是否是搜索二叉树的后序遍历数组
     * @param arr
     * @return
     */
    public static boolean isPostArray(int[] arr){
        if(arr==null||arr.length==0){
            return true;
        }
        int len=arr.length;
        int posLeft=0;
        while(posLeft<len&&arr[posLeft]<arr[len-1]){
            posLeft++;
        }
        int posRight=posLeft;
        while(posRight<len&&arr[posRight]>arr[len-1]){
            posRight++;
        }
        if(posRight!=len-1){
            return false;
        }
        return isPostArray(Arrays.copyOfRange(arr,0,posLeft))&&isPostArray(Arrays.copyOfRange(arr,posLeft,posRight));
    }

    public static boolean isPost(int[] arr){
        if(arr==null||arr.length==0){
            return false;
        }
         return isPostArray(arr);

    }

    /**
     * 将后序遍历数组恢复为搜索二叉树
     * @param arr
     * @return
     */
    public static TreeNode arrayToTree(int[] arr){
       if(arr==null||arr.length==0){
           return null;
       }
        return getTree(arr,0,arr.length-1);
    }

    public static TreeNode getTree(int[] arr, int i,int j){
        if(i>j){
            return null;
        }
        TreeNode node=new TreeNode(arr[j]);
        int index=i;
        while(index<j&&arr[index]<arr[j]){
            index++;
        }
        node.left=getTree(arr,i,index-1);
        node.right=getTree(arr,index,j-1);
        return node;
    }
    public static void main(String[] args) {
        int[] arr={2,3,1};
        System.out.println(isPost(arr));
    }

}
