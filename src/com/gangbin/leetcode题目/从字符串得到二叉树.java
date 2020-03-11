package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/22
 * "4(2(3)(1))(6(5))"
 */
public class 从字符串得到二叉树 {
    public static TreeNode str2tree(String s) {
       if(s==null||s.length()==0){
           return null;
       }
        int num=0;
        int index=0;
        boolean neg=false;
        if(s.charAt(index)=='-'){
            neg=true;
            index++;
        }
        while(index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
            num=num*10+s.charAt(index)-'0';
            index++;
        }
        num=neg?-num:num;
        TreeNode node=new TreeNode(num);
        int mid=getSubstring(s,index);
        if(mid>index){
            node.left=str2tree(s.substring(index+1,mid-1));
        }
        if(mid<s.length()){
            node.right=str2tree(s.substring(mid+1,s.length()-1));
        }
        return node;
    }
    public static int getSubstring(String s,int index){
        if(index==s.length()){
            return index;
        }
        int count=1;
        index++;
        while(index<s.length()&&count!=0){
            if(s.charAt(index)=='('){
                count++;
            }
            if(s.charAt(index)==')'){
                count--;
            }
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        String s="4(2(3)(1))(6(5))";
        str2tree(s);
    }
}
