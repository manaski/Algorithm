package com.gangbin.String;

/**
 * 找到新定义的字符
 * 根据定义的特点反向查找，当然也可以直接从前往后切割
 * 重点是找规律
 */
public class NewTypeOfCharAtK {
    public static String newChar(String s, int k){
        int uNum=0;
        int indx=k-1;
        while(indx>=0&&s.charAt(indx)>='A'&&s.charAt(indx)<='Z'){
            uNum++;
            indx--;
        }
         if(uNum%2==0){
           if(s.charAt(k)>='A'&&s.charAt(k)<='Z') {
               return s.substring(k, k + 2);
           }else{
               return s.substring(k, k + 1);
           }
         }else{
                 return s.substring(k-1, k + 1);
         }
    }

    public static void main(String[] args) {
        String s="aaABCDEcBCg";
        String res=newChar(s,10);
        System.out.println(res);
    }

}
