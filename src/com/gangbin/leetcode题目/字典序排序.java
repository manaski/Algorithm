package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/15
 */
public class 字典序排序 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        process(0,n,res);
        return res;
    }
    public void process(int num, int n, List<Integer> res){
        if(num>n){
            return;
        }
        if(num!=0){
            res.add(num);
        }
        if(num*10>n){
            return;
        }
        for(int i=0;i<9;i++){
            process(num*10+i,n,res);
        }
    }

}
