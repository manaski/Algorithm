package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
class MyException extends Exception {
    public String getMe() throws Exception {
        throw new Exception("234");
    }
}
public class ExceptionTest {
    public static void main(String[] args) throws Exception {
        MyException e=new MyException();
        byte[] c=new byte[]{2,1};
        char[] cc=new char[2];


    }
}
