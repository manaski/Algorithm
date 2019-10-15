package com.gangbin.Company.携程;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/4
 */
public class Main3 {

    public static int get(){
         int b=1;
         return b;

    }
    public static boolean isContained(String s1,String s2){
        int len1=s1.length();
        int len2=s2.length();
        int[] map=new int[128];
        for(int i=0;i<len2;i++){
            map[s2.charAt(i)]++;
        }
        for(int i=0;i<len1;i++){
            if(map[s1.charAt(i)]<=0){
                return false;
            }else{
                map[s1.charAt(i)]--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s1="1123456";
////        String s2="415263798";
////        System.out.println(isContained(s1,s2));
        int i=10;
        i=i++;
        i=++i;
        System.out.println(i);

    }
}
