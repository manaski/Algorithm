package com.gangbin.Others;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 从高楼扔下棋子可能碎也可能不碎，找到最坏情况下尝试次数最少的方法
 * @date 2019/9/8
 */
public class 高楼扔棋子问题 {

    public static int drop1(int n, int k){
        if(n==0){
            return 0;
        }
        if(k==1){
            return n;
        }
        int res=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int r=Math.max(drop1(n-i,k),drop1(i-1,k-1));
            res=Math.min(r,res);
        }
        return res+1;//别忘了加上这次的操作
    }
    public static int drop2(int n, int k){
        if(n==0){
            return 0;
        }
        if(k==1){
            return n;
        }
        int[][] dp=new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            dp[i][1]=i;   //纽扣数量为1
        }

        for(int i=1;i<=n;i++){
            for(int j=2;j<=k;j++){  //纽扣数量从2开始，1已经讨论过了
                dp[i][j]=Integer.MAX_VALUE;
                for(int t=1;t<i;t++){
                    dp[i][j]=Math.min(Math.max(dp[i-t][j],dp[t-1][j-1]),dp[i][j]);//遍历每个可能性
                }
                dp[i][j]++;//最后加上本次操作
            }
        }
        return dp[n][k];
    }
    //逆向思维
    //用k个棋子扔多少次可以解决多少楼的问题
    //可以得到一个记录关系，也就是每次都是选择最优解来进行扔棋子，能够解决的楼层数
    public static int drop3(int n, int k){
        if(n<1||k<1){
            return 0;
        }
        int bsTimes=log2N(n)+1;//计算二分查找的最多次数，如果比这个次数还大的次数，直接返回这个值
        if(k>=bsTimes){
            return bsTimes;
        }
        int[] dp=new int[k];
        int res=0;
        while(true){
            res++;   //记录扔的次数，当扔res次时，i+1个棋子可以用于多少层楼，
            // 本质上是说用这些棋子扔这么多次可以涵盖住几层楼的所有情况
            int previous=0; //初始是0个棋子
            for(int i=0;i<dp.length;i++){
                int temp=dp[i];
             //   System.out.println(temp+"temp");
                dp[i]=dp[i]+previous+1;    //最左列初始都是0，第一行初始时是123456
//                if(i==0){
//                    System.out.println(previous+" "+dp[i]);
//                }
                previous=temp;
                if(dp[i]>=n){
                    return res;
                }
            }
        }

    }
    public static  int drop4(int n,int k){
        int[][]map=new int[n+1][k+1];  //最多搞定几层楼的问题
        for(int i=0;i<=n;i++){
            map[i][1]=i;
        }
        int m=log2N(n)+1;
        if(k>=m){
            return m;
        }
        for(int i=1;i<=n;i++){//固定扔i次
            for(int j=1;j<=k;j++){//用j颗棋子
                map[i][j]=map[i-1][j]+map[i-1][j-1]+1;
                if(map[i][j]>=n){
                    return i;
                }
                System.out.println(Arrays.toString(map[i]));
            }

        }
        return -1;
//        int[] dp=new int[k+1];
//        int pre=0;
//        int res=0;
//        while(true){
//            res++;//记录行数，也就是扔的次数
//            for(int j=1;j<=k;j++){
//                int temp=dp[j];  //记录上一行数据
//                dp[j]=dp[j]+pre+1;
//                pre=temp;   //上一行数据用于下次计算
//                if(dp[j]>=n){
//                    return res;
//                }
//            }
//        }

    }
    public static int log2N(int n){
        int ret=-1;
        while(n!=0){
            ret++;
            n>>>=1;
        }
        return ret;
    }



    public static void main(String[] args) {
//        int re=drop1(10,2);
//        int re2=drop2(10,2);
        int res1=drop3(10,2);
        int res2=drop4(10,2);
        System.out.println(res1+" "+res2);
//        System.out.println(re);
//        System.out.println(re2);
    }
}
