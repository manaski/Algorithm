package com.gangbin.Company.字节跳动;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/11
 */
public class Main3 {
    public static int salary(int n,int[] year){
        if(n<2){
            return n*100;
        }
        int ret=n*100;
        int[] salaries=new int[n];
        getSalary(salaries,year,0);
        for(int i=0;i<n;i++){
            ret+=salaries[i];
        }
        return ret;

    }
    public static void getSalary(int[] salary,int[] year,int idx){
        System.out.println("调用--------"+idx);
        if(idx<0||idx>=year.length){
            return;
        }
        if(idx+1<year.length){
            check(salary,year,idx,idx+1);
        }
        if(idx+1<year.length){
            int ds=(salary[idx]-salary[idx+1]);
            int dy=(year[idx]-year[idx+1]);
            if(dy>0){
                if(ds<=0){
                    salary[idx]=salary[idx+1]+100;
                }
            }else if(dy==0&&ds<0){
                salary[idx]=salary[idx+1];
            }
        }
        if(idx-1>=0){
            int ds=(salary[idx]-salary[idx-1]);
            int dy=(year[idx]-year[idx-1]);
            if(dy==0&&ds<0){
                salary[idx]=salary[idx-1];
            }else if(dy>0&&ds<=0){
                salary[idx]=salary[idx-1]+100;
            }
        }
        if(!check(salary,year,idx,idx-1)){
            getSalary(salary,year, idx-1);
        }
            getSalary(salary,year, idx+1);
    }

    public static boolean check(int[] salary,int[] year,int i,int j){
        if(j<0){
            return true;
        }
        int ds=(salary[i]-salary[j]);
        int dy=(year[i]-year[j]);
        if(dy>0&&ds>0||ds==0&&dy==0||dy<0&&ds<0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        int[] year=new int[n];
        for(int i=0;i<n;i++){
            year[i]=sc.nextInt();
        }
        int res=salary(year.length,year);
        System.out.println(res);
    }
}
