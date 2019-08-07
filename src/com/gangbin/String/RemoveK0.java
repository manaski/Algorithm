package com.gangbin.String;
/**
 * 去掉连续出现k次的0子串
 */
public class RemoveK0 {
    public static String removeK0(String s,int k){
        if(s==null||s.length()==0||k==0||k>s.length()){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        int count=0;
        int begin=0;
        //主要是按字符类型分为不同的情况进行处理，当为目标字符时和不是目标字符时
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                count++;   //记录0的个数
                if(begin==-1){//用-1表示没有0子串的情况
                    begin=i;    //记录0开始的位置
                }
            }else{
                if(begin>-1&&count!=k){
                    sb.append(s.substring(begin,i));   //  0,只有当0的个数不等于k时才会添加
                }
                sb.append(s.charAt(i));//非0一定会添加
                count=0;
                begin=-1;
            }
        }
        if(begin>-1&&count!=k){
           sb.append(s.substring(begin,s.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="000100200300";
        System.out.println(removeK0(s,2));
    }
}
