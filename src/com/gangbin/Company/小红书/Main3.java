package com.gangbin.Company.小红书;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 小偷盗窃的题目，不能偷相邻两家的，但是要偷最大的
 * @date 2019/8/18
 */
public class Main3 {

    public static int[] getNotes(int[] goods) {
        int[] res=new int[2];
        if (goods.length == 0){
            return res;
        }

        if (goods.length == 1){
            res[0]=goods[0];
            res[1]=1;
            return res;
        }

        if (goods.length == 2){
            int indx=goods[0]>goods[1]?0:1;
            res[0]=goods[indx];
            res[1]=1;
            return res;
        }
        //notes[i]表示前i+1个最多的点赞次数
        int[] notes = new int[goods.length];
        notes[0] = goods[0];
        notes[1] = Math.max(goods[0], goods[1]);

        for(int index=2; index < notes.length; index++){
            notes[index] = Math.max(goods[index] + notes[index-2], notes[index -1]);
            res[1]=notes[index]==notes[index -1]?res[1]:res[1]+1;
        }
        res[0]=notes[goods.length -1];
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] goods=new int[n];
        for(int i=0;i<n;i++){
            goods[i]=scanner.nextInt();
        }
        int[] res=getNotes(goods);
        System.out.print(res[0]+" "+res[1]);

    }
}
