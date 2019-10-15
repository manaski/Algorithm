package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 字典顺序第k个数字，相当于查找一个前缀
 * @date 2019/10/1
 */
public class 字典序第k个数字 {
    public int findKthNumber(int n, int k) {
        long p = 1;
        int prefix = 1;
        while(p<k) {
            long count = getCount(prefix,n);
            if(p + count > k) {//在当前前缀范围内
                prefix *= 10; //往下一层继续找
                p++; //增加一个
            } else if(p + count <= k) {
                prefix ++; //横向拓展
                p += count; //增加一个范围数
            }
        }
        return prefix;
    }
    public long getCount(int prefix, int n){//获得当前前缀下共有多少数字
        long cur=prefix;
        long next=cur+1; //下一个前缀是加1，横向拓展，10叉树
        long count=0;
        while(cur<=n){
            count+=Math.min(next,n+1)-cur;
            cur=cur*10;      //乘以10，向下一层拓展
            next=next*10;
        }
        return count;
    }
}
