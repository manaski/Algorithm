package com.gangbin.String;

/**
 * 将一个整数字符串转为整数
 */
public class StringtoNumber {
    public static boolean isValid(String s){
        if(s==null||s.length()==0){
            return false;
        }
        //重点考虑第一位置的情况
       if(s.charAt(0)!='-'&&(s.charAt(0)<'0'||s.charAt(0)>'9')){
           return false;
       }
        if(s.charAt(0)=='-'&&(s.length()==1||s.charAt(1)=='0')){
           return false;
        }
        if(s.charAt(0)=='0'&&s.length()>1){
            return false;
        }
        int index=1;
        while(index<s.length()){
            if(s.charAt(index)<'0'||s.charAt(index)>'9'){
                return false;
            }
            index++;
        }
        return true;
    }
    //由于有溢出的判断，而负数比正数绝对值大一个，所以可以计算负值的累加和判断溢出
    public static int stringToNumber(String s){
        if(!isValid(s)){          //先校验一下
            return 0;
        }
        boolean pos=true;
        int res=0;
        int index=0;
        if(s.charAt(0)=='-'){
            pos=false;
            index++;
        }
        //为了判断溢出
        int minp=Integer.MIN_VALUE/10;
        int minr=Integer.MIN_VALUE%10;
        for(int i=index;i<s.length();i++){
            //提前判断是否会溢出,都是负数
            if(res<minp||(minp==res&&minr>'0'-s.charAt(i))){
                return 0;
            }
            res=res*10+'0'-s.charAt(i);
        }
        //如果是正数，溢出条件
        if(pos&&res==Integer.MIN_VALUE){
            return 0;
        }
        return pos?-res:res;
    }
    public static void main(String[] args) {
        String s="234865555";
        System.out.println(stringToNumber(s));
        int a=1;
    }

}
