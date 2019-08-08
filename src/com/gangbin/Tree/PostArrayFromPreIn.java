package com.gangbin.Tree;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 从前序和中序获得后序数组
 * @date 2019/8/8
 */
public class PostArrayFromPreIn {
    public static int[] getPostArray(int[] pre,int[] in){
        int len=pre.length;
        int[] post=new int[len];
        int[] index=new int[1];
        index[0]=len-1;
        getPost(pre,0,len-1,in,0,len-1,index,post);
        return post;
    }

    /**
     * 从右往左填充目标数组，下标设为全局变量比较方便
     */
    public static void getPost(int[] pre,int ps,int pe,int[] dn,int ds,int de,int[] index,int[] post){
        if(ps>pe){
            return;
        }
        if(ps==pe){
            post[index[0]--]=pre[ps];
            return;
        }
        post[index[0]--]=pre[ps++];
        int idx=ds;
        while(idx<de&&dn[idx]!=post[index[0]+1]){
            idx++;
        }
        getPost(pre,pe+1-de+idx,pe,dn,idx+1,de,index,post);
        getPost(pre,ps,ps+idx-1-ds,dn,ds,idx-1,index,post);
    }

    public static void main(String[] args) {
        int[] pre={1,2,3,4,5,6};
        int[] in={3,2,4,1,5,6};
        int[] ret=getPostArray(pre,in);
        System.out.println(Arrays.toString(ret));
    }
}
