package com.gangbin.Company.拼多多2019;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/25
 */
class Line{
    int begin;
    int end;
    Line(int begin, int end){
        this.begin=begin;
        this.end=end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
public class Main2 {
    public static int fun(List<Line> arr,Line newline){
        arr.add(newline);
        Collections.sort(arr, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.begin-o2.begin;
            }
        });
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i).end>=arr.get(i+1).begin){
                arr.get(i+1).end=Math.max(arr.get(i+1).end,arr.get(i).end);
                arr.get(i+1).begin=Math.min(arr.get(i+1).begin,arr.get(i).begin);
                arr.remove(i--);
            }
        }
        for(Line p:arr){
            System.out.println(p);
        }
        int sum=0;
        for(int i=0;i< arr.size();i++){
            sum+=arr.get(i).end-arr.get(i).begin+1;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m= scanner.nextInt();
        if(n==0||m==0){
            System.out.println(0);
            return;
        }
        List<Line> lines= new ArrayList<Line>();
        for(int i=0;i<m;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if(a>b){
                a=b^a^(b=a);
            }
            Line newline=new Line(a,b);
            fun(lines,newline);
        }
    }
}
