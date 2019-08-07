package com.gangbin.String;

import java.util.Arrays;

/**
 * 将空格字符替换为给定的字符串
 * 要求空间复杂度1，时间复杂度n
 */
public class StringReplaceSpace {
    public static void replaceSpace(char[] chars){
        //先遍历一边也是可以的，获得空格个数
        int num=0;
        int len=0;
        int count=0;
        for(int i=0;i<chars.length;i++){
          if(chars[i]==' '){
              count++;
          }else{
               num=count;
               len=i+1;
          }
        }
        int j=chars.length-1;
        while(chars[j]==' '){
            j--;
        }
        int index=len+2*num-1;
        for(;j>=0;j--){
            if(chars[j]==' '){
                chars[index--]='0';
                chars[index--]='2';
                chars[index--]='%';
            }else{
                chars[index--]=chars[j];
            }
        }
    }
    public static void replaceSpace2(char[] chars){
        int index=chars.length-1;
        int j=chars.length-1;
        for(;j>=0;j--){
            if(chars[j]!='*'){
               chars[index--]=chars[j];
            }
        }
        while(index>=0){
            chars[index--]='*';
        }
    }
    public static void main(String[] args) {
        char[] c={'1',' ','2',' ',' ',' ',' ',' '};
        replaceSpace(c);
        System.out.println(Arrays.toString(c));
        char[] c2={'1','*','2','*','2','*','1','1'};
        replaceSpace2(c2);
        System.out.println(Arrays.toString(c2));
    }
}
