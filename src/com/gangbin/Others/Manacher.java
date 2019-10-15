package com.gangbin.Others;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/9
 */
public class Manacher {
    public static int getMax(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        char[] charArr=manacherString(s);
        int[] pArr=new int[charArr.length]; //每个位置的半径
        int index=-1;  //对称中心
        int pR=-1; //右边界下标  pR=i+pArr[i]
        int max=Integer.MIN_VALUE;
        for(int i=0;i<charArr.length;i++){
            pArr[i]=pR>i?Math.min(pArr[2*index-i],pR-i):1;//取得一个基础半径值，要么是1，要么是距离PR半径，要么是对称点半径
            while(i+pArr[i]<charArr.length&&i-pArr[i]>-1){//向两边查找，直到不满足回文
                if(charArr[i+pArr[i]]==charArr[i-pArr[i]]){//向右扩的次数决定了时间复杂度
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i+pArr[i]>pR){//只有在大于pR时才会更新pR
                pR=i+pArr[i];
                index=i;
            }
            max=Math.max(max,pArr[i]); //回文串为2n+1,半径是n+1
        }
        return max-1;

    }
    public static char[] manacherString(String s){
        char[] c=s.toCharArray();
        char[] chars=new char[c.length*2+1];
        int index=0;
        for(int i=0;i<chars.length;i++){
            chars[i]=(i&1)==1?c[index++]:'#';
        }
        return chars;

    }

    public static void main(String[] args) {
        String s="12345312313";
        int ret=getMax(s);
        System.out.println(ret);
    }
}
