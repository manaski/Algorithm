package com.gangbin.Others;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/14
 */
public class 字符和数字对应 {
    public static String getString(int num,char[] chars){
        //char[] chars={'A','B','C','D','E','F','G','H','I','J','K'};
        //找到位数
        int n=chars.length;//得到进制
        int count=1;//记录最大的权重值
        int len=0;//记录最大位数
        int m=num;//数字
        while(m>=count){
            len++;
            m=m-count;  //1 n n*n n*n*n
            count=count*n;
        }  //len长度，表示低len位每一位都用到了一次
        char[] res=new char[len];
        int index=0;
        int nCur=0;
        do{
            count=count/n;   //向前退一步
            nCur=m/count;  //用剩下的值除以count，看还有几个需要，可能是0
            res[index++]=getCharAtChs(chars,nCur+1);//获得字母
            m=m%count; //计算余数
        }while (index!=res.length);
        return String.valueOf(res);
    }
    public static char getCharAtChs(char[] chars, int n){
        return chars[n-1];
    }

    public static int getNumber(String s,char[] chars){
        char[] c=s.toCharArray();
        int n=chars.length;
        int count=1;
        int len=c.length;
        int res=0;
        for(int i=0;i<c.length;i++){
            res=res+count*(c[len-1-i]-'A'+1);
            count=count*n;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //String s=sc.nextLine();
        char[] chars={'A','B','C'};
        int n=sc.nextInt();
        String res=getString(n,chars);
        System.out.println(res);
        int ret=getNumber(res,chars);
        System.out.println(ret);
    }
}
