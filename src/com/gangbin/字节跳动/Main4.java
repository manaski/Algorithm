package com.gangbin.字节跳动;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
class Game{
    int a;
    int b;
    int happy;

    public Game(int a, int b, int happy) {
        this.a = a;
        this.b = b;
        this.happy = happy;
    }
}
public class Main4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //String s=sc.nextLine();
        int n=sc.nextInt();
        int x=sc.nextInt();
        ArrayList<Game> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Game(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        int cost=0;
        int bargin=0;
        int curHappy=0;
        for(int i=0;i<n;i++){
            cost+=list.get(i).b;
            bargin+=list.get(i).a-list.get(i).b;
            curHappy+=list.get(i).happy;
            if(bargin>=cost-x){

            }else{
                cost-=list.get(i).b;
                bargin-=list.get(i).a-list.get(i).b;
                curHappy-=list.get(i).happy;
            }
        }
        System.out.println(curHappy);
    }
}
