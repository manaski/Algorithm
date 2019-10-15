package com.gangbin.leetcode题目;

import java.util.LinkedList;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
class StockSpanner {
 LinkedList<Integer> stack=null;
 LinkedList<Integer> idxstack=null;
  int index=0;
    public StockSpanner() {
        stack=new LinkedList<>();
        idxstack=new LinkedList<>();
    }

    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(price);
            idxstack.push(index++);
            return 1;
        }else{
            while(!stack.isEmpty()&&stack.peek()<price){
                stack.pop();
                idxstack.pop();
            }
            int res=0;
            if(stack.isEmpty()){
                res=index+1;
            }else{
                res=index-idxstack.peek();
            }
            stack.push(price);
            idxstack.push(index++);
            return res;
        }
    }
}
public class 股票价格跨度 {
}
