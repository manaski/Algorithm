package com.gangbin.Tree;

public class PostArrayToTree {
    public TreeNode postToTree(int[] arr){
        if(arr==null||arr.length==0){
            return null;
        }
        return postTree(arr,0,arr.length-1);

    }
    public TreeNode postTree(int[] arr, int begin, int end){
        if(begin>end){
            return null;
        }
        int less=-1;
        int more=end;
        int index=begin;
        while(index<end&&arr[index]<arr[end]){
            index++;
        }
        less=index-1;
        more=index;
        TreeNode node=new TreeNode(arr[end]);
        node.left=postTree(arr,begin,less);
        node.right=postTree(arr,more,end-1);
        return node;
    }

}
