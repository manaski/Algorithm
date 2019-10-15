package com.gangbin.Tree.累加和为指定值的最长路径;

import com.gangbin.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长路径累加和为指定值
 */
public class MaxLengthSumToK {
    public int getMaxLengt(TreeNode node, int k){
        if(node==null){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();//记录某个加和第一次出现的下标
        map.put(0,0);   //第0层就可以得到和为0，这个必须要加上
        int len=0;
        int sum=0;
        int level=0;
        int res=preOrder(node,level+1,k,sum,len,map);
        return res;
    }
    public int preOrder(TreeNode node,int level,int k, int sum,int len,Map<Integer,Integer> map){
        if(node==null){
            return len;
        }
        int val=node.val;
        sum+=val;
        if(map.containsKey(sum-k)){
            int lev=map.get(sum-k);
            len= Math.max(len,level-lev);
        }
        if(!map.containsKey(sum)){
            map.put(sum,level);
        }
        int left=preOrder(node.left,level+1,k,sum,len,map);
        int right=preOrder(node.right,level+1,k,sum,len,map);
        return Math.max(left,right);
    }
}
