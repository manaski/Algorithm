package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
public class 最长回文串 {
    public static String maxHuiwen(String s){
        if(s==null||s.length()<2){
            return s;
        }
        String ss=getmancher(s);
        int maxR=-1;
        int maxC=-1;
        int maxL=0;
        int maxi=-1;
        int[] arrP=new int[ss.length()];
        for(int i=0;i<ss.length();i++){
            arrP[i]=maxR>i?Math.min(arrP[2*maxC-i],maxR-i):1;
            while(i+arrP[i]<ss.length()&&i-arrP[i]>=0&&ss.charAt(i+arrP[i])==ss.charAt(i-arrP[i])){
                arrP[i]++;
            }
            if(i+arrP[i]>maxR){
                maxC=i;
                maxR=i+arrP[i];
            }
            if(arrP[i]>maxL){
                maxL=arrP[i];
                maxi=i;
            }
        }
//        System.out.println(maxi+" "+maxL);
//        System.out.println((maxi-maxL+2)/2+" "+(maxi+maxL-1)/2);
        return s.substring((maxi-maxL+2)/2,(maxi+maxL-1)/2);
       // return maxL-1;

    }
    public static String getmancher(String s){
        char[] c=s.toCharArray();
        char[] res=new char[c.length*2+1];
        int index=0;
        for(int i=0;i<res.length;i++){
         if((i&1)==1){
             res[i]=c[index++];
         }else{
             res[i]='&';
         }

        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s="21";
        System.out.println(getmancher(s));
        System.out.println(maxHuiwen(s));;
    }
}
