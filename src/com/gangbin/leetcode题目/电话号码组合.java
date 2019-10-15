package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */

public class 电话号码组合 {
    public List<String> letterCombinations(String digits) {
        String[] dial={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};//23456789
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        process(digits,2,dial,sb,res);
        return res;
    }
    public void process(String digits,int index,String[] dial, StringBuilder sb,List<String> res){
        if(index>9){
            res.add(sb.toString());
            return;
        }
        String ss=dial[index-2];
        for(int i=0;i<ss.length();i++){
            sb.append(ss.charAt(i));
            process(digits,index+1, dial, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String s="12";
        List<String> res=new 电话号码组合().letterCombinations(s);
        System.out.println(res);
    }
}
