package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/11
 */
public class 数组分为三个相等部分 {

    public static boolean canThreePartsEqualSum(int[] A) {
        long sum=0;
        for(int num:A){
            sum+=num;
        }
        if(sum%3==1||sum%3==2){
            return false;
        }
        int i=0;
        long m=sum/3;
        long s1=A[i];
        while(++i<A.length&&s1!=m){
            s1+=A[i];
        }
        if(i>=A.length){
            return false;
        }
        long s2=A[i];
        while(++i<A.length&&s2!=m){
            s2+=A[i];
        }
        if(i>=A.length){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A={-3,3,-6};
        boolean re=canThreePartsEqualSum(A);
        System.out.println(re);


    }
}
