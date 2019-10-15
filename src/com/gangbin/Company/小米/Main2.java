package com.gangbin.Company.小米;

/**
 * @author gangbin.li
 * @description: 保持清晰的思路才是最重要的
 * @date 2019/9/6
 */
public class Main2 {
    public static void print(char[] c,int start, int end){
        //为空
        if(start>end){
            return ;
        }
        //为数字
        if(start==end){
            System.out.print(Integer.valueOf(c[start]-'0')+",");
            return;
        }
        int mid=-1;
        //数字加括号
        int begin1=start+2;
        //1(,12)
        if(c[begin1]==','){
            mid=begin1;
        }else{
            //1(1(),2),找到匹配的括号
            if(c[begin1+1]=='('){
                int index=begin1+2;
                int count=1;
                while(index<=end){
                    if(c[index]=='('){
                        count++;
                    }
                    if(c[index]==')'){
                        count--;
                        if(count==0){
                            break;
                        }
                    }
                    index++;
                }
                mid=index+1;
            }else{//1(1,2())
                mid=begin1+1;
            }
        }

        print(c, start+2, mid-1);
        System.out.print(c[start]-'0'+",");
        print(c, mid+1, end-1);
    }

    public static void main(String[] args) {
        String s="3(1,2)";
        print(s.toCharArray(),0,s.length()-1);
    }

}
