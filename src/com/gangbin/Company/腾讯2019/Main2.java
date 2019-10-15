package com.gangbin.Company.腾讯2019;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/20
 */
public class Main2 {
    public static int donetime(int[] num,int[] val){
        int i=0;
        int j=num.length-1;
        int max=Integer.MIN_VALUE;
        while(i<j){
            max=Math.max(val[i]+val[j],max);
            num[i]--;
            num[j]--;
            while(num[i]<=0){
                i++;
            }
            while(num[j]<=0){
                j--;
            }
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int[] num=new int[n];
        int[] val=new int[n];
        for(int i=0;i<n;i++){
            int k1=scanner.nextInt();
            int k2=scanner.nextInt();
            map.put(k2,k1);
        }
        int i=0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            val[i]=e.getKey();
            num[i++]=e.getValue();
        }
        //System.out.println(Arrays.toString(val));
        donetime(num,val);
    }
}
