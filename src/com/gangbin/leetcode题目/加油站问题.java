package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/16
 */
public class 加油站问题 {
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int cur=startFuel;
        int next=-1;
        int count=0;
        int index=0;
        int i=0;
        int sum=startFuel;
        for(;i<target;){
            if(stations!=null&&index<stations.length&&stations[0].length>0&&i==stations[index][0]){
                next=Math.max(next,cur+stations[index++][1]);
            }
            if(i>=cur){
                if(next<=cur){
                    count=-1;
                    break;
                }
                cur=next;
                count++;
            }
            i=Math.min(cur,index<stations.length?stations[index][0]:cur+1);
        }
        System.out.println(count);
        if(i>=target){
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] stations={{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}};
        int target=1000;
        int startFuel=299;
        minRefuelStops(target,startFuel,stations);
    }
}
