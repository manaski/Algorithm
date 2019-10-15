package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/19
 */
public class 区间合并 {
    public static int[][] merge(int[][] intervals) {
        int[][]res=null;
        Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
        int len=intervals.length;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=intervals[i-1][1]){
                intervals[i][0]=intervals[i-1][0];
                if(intervals[i][1]<=intervals[i-1][1]){
                    intervals[i][1]=intervals[i-1][1];
                }
                intervals[i-1][0]=intervals[i-1][1]+1;
                len--;
            }
        }
        res=new int[len][2];
        int j=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=intervals[i][1]){
                res[j][0]=intervals[i][0];
                res[j++][1]=intervals[i][1];
            }
        }
                for(int[] p:intervals){
            System.out.println(Arrays.toString(p));
        }
        return res;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index=0;
        int[][]res=null;
        while(intervals[index][0]<newInterval[0]){
            index++;
        }
        //找到第一个大于等于的位置 index
        //从index-1开始向后合并
        if(index==0){
            intervals[index][0]=newInterval[0];
            if(intervals[index][1]<newInterval[1]){
                intervals[index][1]=newInterval[1];
            }
        } if(index==intervals.length){



        }else{
            if(intervals[index-1][1]>=newInterval[0]){
                intervals[index-1][1]=newInterval[1];
            }
            index--;
        }
        int len=intervals.length;
        for(int i=index;i<intervals.length;i++){
            if(intervals[i][0]<=intervals[i-1][1]){
                intervals[i][0]=intervals[i-1][0];
                if(intervals[i][1]<=intervals[i-1][1]){
                    intervals[i][1]=intervals[i-1][1];
                }
                intervals[i-1][0]=intervals[i-1][1]+1;
                len--;
            }
        }
        res=new int[len][2];
        int j=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=intervals[i][1]){
                res[j][0]=intervals[i][0];
                res[j++][1]=intervals[i][1];
            }
        }
//        for(int[] p:intervals){
//            System.out.println(Arrays.toString(p));
//        }
        return res;
    }
    public static void main(String[] args) {
        int[][]a={{2,3},{5,5},{2,2},{3,4},{3,4}};
//        Arrays.sort(a, (o1,o2)->o1[0]-o2[0]);
//        for(int[] p:a){
//            System.out.println(Arrays.toString(p));
//        }
        merge(a);
    }
}
