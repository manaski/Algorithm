package com.gangbin.leetcode题目;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/29
 */
public class 搜索树的众数 {
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        LinkedList<TreeNode> stack=new LinkedList<>();
        int maxCount=0;
        int maxNum=0;
        Integer pre=null;
        int count=1;
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                if(pre==null){
                    pre=root.val;
                }else{
                    if(pre.intValue()==root.val){
                        count++;
                        if(maxCount<count){
                            maxCount=count;
                            maxNum=root.val;
                        }
                    }else{
                        map.put(pre,count);
                        pre=root.val;
                        count=1;
                    }
                }

                root=root.right;
            }
        }
        int len=0;
        int index=0;
        int[] res=new int[map.size()];
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()==maxCount){
                res[index++]=e.getKey();
                len++;
            }
        }

        return res;

    }
}
