package com.gangbin.Company.字节跳动;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/11
 */
public class Main2 {
    public static String decode(String str,int n,int k){
        if(n<1){
            return "";
        }
        if(k==0){
            return str;
        }
        int len=str.length();    //n+k-1
        int[] bytes=new int[len];
         for(int i=0;i<len;i++){
             bytes[i]=str.charAt(i)-48;
         }
         int[] msg=new int[n];
         msg[0]=bytes[0];
         int help=msg[0];
         for(int i=1;i<k;i++){
            msg[i]=bytes[i]^help;
            help=help^msg[i];
         }
        for(int i=k;i<n;i++){
            help=help^msg[i-k];
            msg[i]=bytes[i]^help;
            help=help^msg[i];
        }
        StringBuilder ret=new StringBuilder();
        for(int i=0;i<n;i++){
            ret.append(msg[i]);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String str="1110001";
        int n=6;
        int k=2;
      //  System.out.println(decode(str,n,k));
        byte a=1;
        byte b=1;
        byte c=(byte)(a^b);
        System.out.println(c);

    }
}
