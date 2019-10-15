package com.gangbin.leetcode题目;

import java.util.Stack;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/16
 */
public class 匹配括号 {
    public boolean isValid(String s) {
        char[] c=s.toCharArray();
        int i=0;
        int[] count=new int[3];
        for(;i<c.length;i++){
            if(c[i]=='('){
                count[0]++;
            }
            if(c[i]=='['){
                count[1]++;
            }
            if(c[i]=='{'){
                count[2]++;
            }
            if(c[i]==')'){
                count[0]--;
                if(count[0]<0){
                    return false;
                }
            }
            if(c[i]==']'){
                count[1]--;
                if(count[1]<0){
                    return false;
                }
            }
            if(c[i]=='}'){
                count[2]--;
                if(count[2]<0){
                    return false;
                }
            }
        }
        for(int j=0;j<3;j++){
            if(count[j]>0){
                return false;
            }
        }
        return true;

    }
    public boolean isValid1(String s) {
        char[] c=s.toCharArray();
        int i=0;
        Stack<Character> stack=new Stack<>();
        for(;i<c.length;i++){
            if(c[i]=='('||c[i]=='['||c[i]=='{'){
                stack.push(c[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char cc=stack.peek();
                if(c[i]==')'&&cc=='('){
                    stack.pop();
                }else  if(c[i]=='}'&&cc=='{'){
                    stack.pop();
                }else if(c[i]==']'&&cc=='['){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}
