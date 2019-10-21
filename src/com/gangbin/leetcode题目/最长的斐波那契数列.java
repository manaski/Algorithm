package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/18
 */
interface momo{
    String name="momo";
    void fun();
    default void fun2(){

    }
     static int fun3(){
        return 1;
    }
}
public class 最长的斐波那契数列 {
    Integer maxLen=2;
    class inner{
        public int getInt(){
            return maxLen+1;
        }
    }
    {
        maxLen=3;
    }


}
