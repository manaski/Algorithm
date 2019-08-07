package com.gangbin.String;

import java.util.ArrayList;
import java.util.List;

/**
 * 将字符数组中的单词前后位置调换
 * 通过整体翻转和局部翻转实现  O(n)
 */
public class ReverseWords {

    //需要额外的存储空间O(n),时间复杂度O(n)
    public static String reverseTheWords(char[] chars){
        String s=String.valueOf(chars);
//        String ss[]=s.split(" ");
//        StringBuilder sb=new StringBuilder();
//        for(int i=ss.length-1;i>=0;i--){
//            sb.append(ss[i]);
//            sb.append(" ");
//        }

        List<String> list=new ArrayList<>();
        int begin=-1;
        for(int i=0;i<chars.length;i++){
            if(chars[i]!=' '){
                if(begin==-1){
                    begin=i;
                }
            }else{
                if(begin>-1){
                    list.add(String.valueOf(chars, begin,i-begin));
                    begin=-1;
                }
            }
        }
        if(begin>-1){
            list.add(String.valueOf(chars, begin,chars.length-begin));
        }
        System.out.println(list);
        StringBuilder sb=new StringBuilder();
        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i));
            sb.append(" ");
        }
       return  sb.toString().trim();
    }

    //原地翻转原来的数组，然后将每个单词进行翻转，从而最后的结果翻转了
    public static void rotateWords(char[] chars){
        if(chars==null||chars.length==0){
            return;
        }
        reverse(chars,0,chars.length-1);
        int l=-1;
        int r=-1;
        for(int i=0;i<chars.length;i++){
            if(chars[i]!=' '&&(i==0||chars[i-1]==' ')){
                l=i;
            }
            if(chars[i]!=' '&&(i==chars.length-1||chars[i+1]==' ')){
                r=i;
            }
            if(l!=-1&&r!=-1){
               // System.out.println("l"+l+"r"+r);
                reverse(chars,l,r);
                l=-1;
                r=-1;
            }
        }

    }
    public static void reverse(char[] chars,int begin, int end){
        while(begin<end){
            char temp=chars[begin];
            chars[begin++]=chars[end];
            chars[end--]=temp;
        }
    }

    public static void main(String[] args) {
        String s="123 456 789.";
        char[] c=s.toCharArray();
      //  String res=reverseTheWords(c);
      //  System.out.println(res);
        rotateWords(c);
        System.out.println(String.valueOf(c));
    }
}
