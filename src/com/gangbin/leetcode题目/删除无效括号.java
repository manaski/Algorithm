package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/25
 */
public class 删除无效括号 {

    public static List<String> removeInvalidParentheses(String s) {
            List<String> res=new ArrayList<>();
            StringBuilder sb1=new StringBuilder(s);
            remove(sb1,new char[]{'(',')'},0,0,res);
            return res;
    }
    public static void remove(StringBuilder s,char[] c, int m, int n, List<String> res){
            int stack=0, i=m;
            for(; i < s.length(); ++i){
                if (s.charAt(i)== c[0]) stack++;//记录左括号和右括号
                if (s.charAt(i) == c[1]) stack--;
                if (stack >= 0) continue;//左括号大于右括号时，正常遍历

                //当右括号多了，当右括号多了的情况下，后面再怎么处理，这个字符串都是无效的
                for (int j = n; j <= i; ++j) {
                    if (s.charAt(j)==c[1] && (j == n || s.charAt(j-1) !=c[1])) {//如果是连续的右括号，只会处理一次
                        String ss = s.substring(0, j) + s.substring(j + 1);
                        StringBuilder sb2=new StringBuilder(ss);//尝试所有可能的操作，删除某个右括号，使目前的括号匹配
                        remove(sb2, c, i, j, res);//后面的遍历操作从i开始，如果要删除字符串，从j开始
                        //注意，这里新字符串实际长度小了一个
                    }
                }
                return;//找到一个处理点之后就停止循环了，因为后面处理都没有用了，交给下一层递归
            }
            //执行到这里，说明i>=s.length()，已经遍历过一遍了，当左括号多的时候，也会执行到这里。
           // 所以这里翻转一下，用左括号多做条件，重新判断
            s.reverse();
            if(c[0]=='('){//
                remove(s, new char[]{c[1], c[0]}, 0, 0, res);
            }else{
                res.add(s.toString());
            }
    }

    public static void main(String[] args) {
        String s="(a)(()(()";
        removeInvalidParentheses(s);
    }

}
