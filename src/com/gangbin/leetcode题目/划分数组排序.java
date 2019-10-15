package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 获得最多的排序的块。利用栈的特性记住每个块的最大值，用后面的值进行判断
 * @date 2019/9/30
 */
public class 划分数组排序 {
    public int maxChunksToSorted(int[] arr) {
        int len=arr.length;
        LinkedList<Integer> stack=new LinkedList<>();
        for(int num:arr){
            if(!stack.isEmpty()&&stack.peek()>num){
                int max=stack.pop();
                while(!stack.isEmpty()&&stack.peek()>num){
                    stack.pop();  //如果新的数字很小，前面的块都要合并掉
                }
                stack.push(max);
            }else{
                stack.push(num);
            }
        }
        return stack.size();
    }
}
