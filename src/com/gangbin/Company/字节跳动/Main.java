package com.gangbin.Company.字节跳动;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/8
 */
public class Main {

    public static int getScore(char[] c,int i,int j){
        char[] chars= Arrays.copyOfRange(c,i,j+1);
        int len=chars.length;
        int[] path=new int[len];
        for(int k=0;k<len;k++){
            if(chars[k]=='<'){
                path[k]=-3;//左
            }else if(chars[k]=='>'){
                path[k]=-4;//右
            }else{
                path[k]=chars[k]-'0';
            }
        }
        int score=0;
        int index=0;
        int dirc=-4;
        int pre=-1;
        while(index>=0&&index<len){
            if(path[index]==-3){
                dirc=-3;
                pre=index;
                index--;
                while(index>=0&&path[index]==-1){
                  index--;
                }
                if(index>=0&&(path[index]==-3||path[index]==-4)){
                    path[pre]=-1;
                }
            } else if(path[index]==-4){
                dirc=-4;
                pre=index;
                index++;
                while(index<len&&path[index]==-1){
                    index++;
                }
                if(index<len&&(path[index]==-3||path[index]==-4)){
                    path[pre]=-1;
                }
            }else if(path[index]>=0){
                score+=path[index];//加分数
                path[index]--;//减分数
                index=dirc==-4?index+1:index-1;
            }else{
                index=dirc==-4?index+1:index-1;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int t=sc.nextInt();
//        int m=sc.nextInt();
//        sc.nextLine();
        //">2<5>3<";
        String s=sc.nextLine();
//        char[] c=s.toCharArray();
//        for(int i=0;i<m;i++){
//            int x=sc.nextInt();
//            int y=sc.nextInt();
//            int ret=getScore(c,x-1,y-1);
//            System.out.println(ret);
//        }
        s=s.replace(" ","");
        System.out.println(s);

    }
}
