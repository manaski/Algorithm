package com.gangbin.String.KMS算法;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/14
 */
public class KMSTest {
    public int[] getNext(String s){
        char[] p=s.toCharArray();
        int pLen=s.length();
        int[] next=new int[pLen];
        next[0] = -1;  //初始值为-1
        int k = -1;
        int j = 0;
        while (j < pLen - 1)
        {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p[j] == p[k])
            {
                ++j;
                ++k;
                //较之前next数组求法，改动在下面4行
                if (p[j] != p[k])
                    next[j] = k;   //之前只有这一行
                else
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
            }
            else
            {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }
    public int find(String str,String pat){
        if(str==null||pat==null||str.length()==0||pat.length()==0){
            return -1;
        }
        char[] s=str.toCharArray();
        char[] p=pat.toCharArray();
        int[] next=getNext(pat);
        int sLen=str.length();
        int pLen=pat.length();
        int i=0;
        int j=0;
        while (i < sLen && j < pLen)
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s[i] == p[j])
            {
                i++;
                j++;
            }
            else
            {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if(j==pLen){
            return i-j;
        }
        return -1;

    }

    public static void main(String[] args) {
        String s="asdafaesdf";
        String p="afae";
        System.out.println(new KMSTest().find(s,p));
    }
}
