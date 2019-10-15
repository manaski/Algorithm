package com.gangbin.Company.百度;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/17
 */
public class Main {
    public static long process(long n, long m, long k){
        long i=0;
        long j=0;
        long min=Integer.MAX_VALUE;
        long a=(m+n);
        long x1=a-k;
        long x2=a+k;
       for(i=x1;i<=x2;i++){
            if(i>0){
                System.out.println(i);
                return i;

            }
       }
        System.out.println(x1);
       return min;
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        long n=sc.nextInt();
//        long m=sc.nextInt();
//        long k=sc.nextInt();
//        if(k==m*n){
//            System.out.println(0);
//            return;
//        }
//        process(n,m,k);
        char[] c={'1'};
        String s="1";
//        Person cc=new child();
//        cc.sing();
//        cc.dance();
        child dd=(child) new Person();
        dd.sing();
        dd.dance();
    }
}
class Person{
    String name;
    static {
        System.out.println("p A");
    }
    {
        System.out.println("P B");
    }
    Person(){
        System.out.println("P C");
    }
    public void sing(){
        System.out.println("P sing");
    }
    public void dance(){
        System.out.println("p dance");
    }
}
class child extends Person{
    static {
        System.out.println("c A");
    }

    child(){
        System.out.println("c C");
    }
    {
        System.out.println("c B");
    }
    public void sing(){
        System.out.println("c sing");
    }
}


