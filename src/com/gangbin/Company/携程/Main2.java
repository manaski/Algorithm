package com.gangbin.Company.携程;

import java.util.Stack;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/4
 */
public class Main2 {

    static String resolve(String expr) {
        if(expr==null||expr.trim().length()==0){
            return "";
        }
        if(!check(expr)){
            return "";
        }
        StringBuilder sb=new StringBuilder(reverse(expr,0,expr.length()-1));
        return sb.toString();
    }
    public static String reverse(String str,int start, int end){
        StringBuilder sb=new StringBuilder();
        for(int i=start;i<end;i++){
            if(str.charAt(i)=='('){
                i++;
                int begin=i;
                int count=1;
                while(i<=end&&count>0){
                    if(str.charAt(i)==')'){
                        count--;
                        if(count==0){
                            break;
                        }
                    }
                    if(str.charAt(i)=='('){
                        count++;
                    }
                    i++;
                }
                sb.append(reverse(str,begin,i));
            }else{
                sb.append(str.charAt(i));
            }
        }
        int j=end;
        while(str.charAt(j)!=')'){
            j--;
        }
        sb.append(str,j+1,end+1);
        return sb.reverse().toString();
    }
    public static boolean check(String expr){
        char[] chars=expr.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                stack.push(chars[i]);
            }
            if(chars[i]==')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;

        }else{
            return false;
        }
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String s=sc.nextLine();
        String s="(1(32()4(65))";
        String ret=resolve(s);
        System.out.println(check(s));
        System.out.println(ret);

    }
}
