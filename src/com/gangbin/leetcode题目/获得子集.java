package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/16
 */
public class 获得子集 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for(Integer t:nums){
            list.add(t);
        }
        res.add(new ArrayList<>());
        List<Integer> temp=new ArrayList<>();
        process(list,res, temp,0);
        return res;
    }

    public static void process(List<Integer> list,List<List<Integer>> res, List<Integer> temp,int index){
        int i=index;
        if(index==list.size()){
            return;
        }
        for(;i<list.size();i++){
            while(i>index&&i<list.size()&&list.get(i).equals(list.get(i-1))){
                i++;
            }
            if(i==list.size()){
                break;
            }
             temp.add(list.get(i));
             res.add(new ArrayList<>(temp));
             process(list,res, temp,i+1);
             temp.remove(Integer.valueOf(list.get(i)));
        }
    }

    public static void main(String[] args) {
        int[]arr=new int[]{1,1,2,2};
        subsets(arr);
    }

}
