package com.gangbin.Others;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/9
 */
public class KMP算法 {
    public static int[] getNext(String s){
        int i=0;
        int k=-1;
        int len=s.length();
        int[] next=new int[len+1];
        next[0]=-1;
        while(i<len){
            if(k==-1||s.charAt(i)==s.charAt(k)){
                i++;//表示当前位置  i++ i向右移动，次数最多M次
                k++;//表示有多长的头尾匹配 k增大
                next[i]=k;
            }else{
                k=next[k];  //k减少 i-k增大的
            }
        }
        return next;
    }

    public static int getSubString(String s,String p){
        int len1=s.length();
        int len2=p.length();
        int[] next=getNext(p);
        int i=0;
        int j=0;
        while(i<len1){
            if(j==-1||s.charAt(i)==p.charAt(j)){
                i++;      //i向右滑动
                j++;
                if(j>=len2){
                    return i-len2;
                }
            }else {
                j=next[j];   //同样i-j变大
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s="123123";
        String p="312";
        int res=getSubString(s,p);
        System.out.println(res);
    }

}
