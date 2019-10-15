package com.gangbin.Company.美团;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */
public class Main2 {
    //整数部分
    public static String print1(String s){
        if(s==null){
            return "";
        }
        Integer t=Integer.valueOf(s);
        if(t==0){
            return "零元";
        }
        char[] shuzi={'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
        char[] bigdan={'元','拾','佰','仟','万','亿'};  //万4 亿8
        char[] money={'角','分','整'};
        int index=0;
        StringBuilder sb=new StringBuilder();
        int count=s.length()-1; //10的次数
        int p=0;
        while(p<s.length()){
            int num=0;
            //找到第一个数字
            while(p<s.length()&&s.charAt(p)=='0'){
                num++;
                p++;
                count--;
            }
            if(p>=s.length()){
                return sb.toString();
            }
            if(num>0){
                sb.append("零");
            }
            //压入数字
            int indx=s.charAt(p)-'0';
            sb.append(shuzi[indx]);
            //压入单位
            StringBuilder sb2=new StringBuilder();
            int cnt=count;
            if(cnt<=4){
                sb2.append(bigdan[cnt]);
            }else{
                //看有几个万或者亿
                while(cnt>8){
                    sb2.append(bigdan[5]);
                    cnt-=8;
                }
                while(cnt>4){
                    sb2.append(bigdan[4]);
                    cnt-=4;
                }
                if(cnt>0){
                    sb2.append(bigdan[cnt]);
                }
            }
            sb.append(sb2.reverse());
            p++;
            count--;
        }
        return sb.toString()+"元";
    }
    public static String getAfter(String s){
        char[] money={'角','分','整'};
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i<2&&s.charAt(i)!='0'){
                sb.append(s.charAt(i)-'0');
                sb.append(money[i]);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String[] ss=s.substring(1,s.length()-1).split(",");
        String s2=ss[0];
        String str=print1(s2.substring(1,s2.length()-1));
        System.out.println(str);
    }
}
