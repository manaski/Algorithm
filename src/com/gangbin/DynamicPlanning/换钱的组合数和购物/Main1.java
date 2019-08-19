package com.gangbin.DynamicPlanning.换钱的组合数和购物;

import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 用固定钱数购买商品，或者兑换零钱的问题
 * @date 2019/8/18
 */
public class Main1 {

    //暴力搜索的方法
    public static int process1(int[] price,int money){
        if(price==null||price.length==0||money<0){
            return 0;
        }
        return count1(price, 0,money);
    }
    public static  int count1(int[] price,int index,int money){
        int res=0;
        if(index==price.length){
            res=money==0?1:0;
        }else{
            for(int i=0;i*price[index]<=money;i++){//每种钱的使用数量进行循环，遍历所有情况
                res+=count1(price,index+1,money-price[index]*i);
            }
        }
        return res;
    }

    //记忆化搜索，对上面的优化，每次递归前去保存的数组中查一下是否已经遍历过了
    public static int process2(int[] price,int money){
        if(price==null||price.length==0||money<0){
            return 0;
        }
        int[][] map=new int[price.length+1][money+1];//表示用钱j购买前i+1个商品的组合数
        return count2(price, 0,money,map);
    }
    public static  int count2(int[] price,int index,int money,int[][]map){
        int res=0;
        if(index==price.length){
            res=money==0?1:0;
        }else{
            for(int i=0;i*price[index]<=money;i++){//每种钱的使用数量进行循环，遍历所有情况
                int mapVal=map[index+1][money-price[index]*i];//如果下一轮递归已经做过了就不再做了
                if(mapVal!=0){
                    res+=mapVal==-1?0:mapVal;
                }else{
                    res+=count2(price,index+1,money-price[index]*i,map);
                }
            }
        }
        map[index][money]=res==0?-1:res;   //记忆本次递归结果
        return res;
    }

    //动态规划算法 时间复杂度 O(N*money^2)
    public static  int count3(int[] price,int money){
        if(price==null||price.length==0||money<0){
            return 0;
        }
        int[][]dp=new int[price.length][money+1]; //表示前i+1的商品，钱数j的组合数
        for(int i=0;i<price.length;i++){
            dp[i][0]=1;    //用0钱购买i+1种商品
        }

        for(int j = 1; price[0]*j<=money;j++){
            dp[0][price[0]*j]=1;  //购买0号商品的组合数，只有当钱数是价格倍数时才可以
        }

        int num=0;
        for(int i=1;i<price.length;i++){
            for(int j=1;j*price[i]<=money;j++){
                num=0;
                for(int k=0;j-price[i]*k>=0;k++){
                    num+=dp[i-1][j-price[i]*k];   //购买k个商品i的可能组合数 累加
                    //这个累加的过程，可以省略为dp[i][j-price[i]]+dp[i-1][j]，也就是不买第i种商品或者至少买一个
                }
                dp[i][j]=num;
            }
        }
        return dp[price.length-1][money];
    }

    //优化动态规划，降低复杂度
    public static int count4(int[] price,int money){
        if(price==null||price.length==0||money<0){
            return 0;
        }
        int[][]dp=new int[price.length][money+1]; //表示前i+1的商品，钱数j的组合数
        for(int i=0;i<price.length;i++){
            dp[i][0]=1;    //用0钱购买i+1种商品
        }

        for(int j = 1; price[0]*j<=money;j++){
            dp[0][price[0]*j]=1;  //购买0号商品的组合数，只有当钱数是价格倍数时才可以
        }

        for(int i=1;i<price.length;i++){
            for(int j=1;j<=money;j++){
                dp[i][j]=dp[i-1][j];
                dp[i][j]+=j-price[i]>=0?dp[i][j-price[i]]:0;
            }
        }
        return dp[price.length-1][money];
    }

    //优化动态规划，降低空间复杂度
    public static int count5(int[] price,int money){
        if(price==null||price.length==0||money<0){
            return 0;
        }
        int[]dp=new int[money+1];

        for(int j = 0; price[0]*j<=money;j++){
            dp[price[0]*j]=1;
        }
        for(int i=1;i<price.length;i++){//控制行数
            for(int j=1;j<=money;j++){//控制列数
                dp[j]=dp[j]+(j-price[i])>=0?dp[j-price[i]]:0;
            }
        }
        return dp[money];
    }



    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String ss[]=s.split(" ");
        int money=Integer.valueOf(ss[0]);
        String sss[]=ss[1].substring(1,ss[1].length()-1).split(",");
        int len=sss.length;
        int[] price=new int[len];
        for(int i=0;i<len;i++){
            price[i]=Integer.valueOf(sss[i]);
        }

    }
}
