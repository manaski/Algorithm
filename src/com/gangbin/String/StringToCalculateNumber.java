package com.gangbin.String;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 计算一个表达式字符串的结果
 * 里面含有括号和正负号
 *
 */
public class StringToCalculateNumber {
    public int getValue(String s){
        return value(s.toCharArray(),0)[0];
    }
    //每次递归用一个双向队列记录遍历的过程，可以进行最后的结果计算
    public int[] value(char[] chars,int i){
        //处理递归
        Deque<String> queue=new LinkedList<>();
        int[] res=null;
        int pre=0;
        while(i<chars.length&&chars[i]!=')'){
            if(chars[i]>='0'&&chars[i]<='9'){
                pre=pre*10+chars[i++]-'0';
            }else if(chars[i]!='('){
                addNum(queue,pre);
                queue.addLast(String.valueOf(chars[i++]));
                pre=0;
            }else{
                res=value(chars,i+1);
                pre=res[0];
                i=res[1]+1;
            }
        }
        //遇到符号才会压数字，最后一个数字没有压
        addNum(queue,pre);
        return new int[]{getNum(queue),i};
    }

    public void addNum(Deque<String> queue,int num){
        if(!queue.isEmpty()){
            String s=queue.pollLast();
            if(s.equals("+")||s.equals("-")){
                queue.addLast(s);
            }else{
                String s1=queue.pollLast();
                int snum=Integer.valueOf(s1);
                num=s.equals("*")?num*snum:snum/num;
            }
        }
        queue.addLast(String.valueOf(num));
    }

    public int getNum(Deque<String> queue){
        int res=Integer.valueOf(queue.pollFirst());
        while(!queue.isEmpty()){
            String s=queue.pollFirst();
            if(s.equals("+")){
                res+=Integer.valueOf(queue.pollFirst());
            }else if(s.equals("-")){
                res-=Integer.valueOf(queue.pollFirst());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s="(-2)+2*5-(-5+2*4)";
        int res=new StringToCalculateNumber().getValue(s);
        System.out.println(res);
    }

}
