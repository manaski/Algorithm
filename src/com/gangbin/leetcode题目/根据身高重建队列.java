package com.gangbin.leetcode题目;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/29
 */
public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o2[0]-o1[0];
                }
            }
        });
        for(int[] p:people){
            System.out.println(Arrays.toString(p));
        }
        List<int[]> list=new LinkedList<>();
        int[][] res=new int[people.length][2];

        for(int i=0;i<people.length;i++){
            list.add(res[i][1],res[i]);
        }
        for(int i=0;i<people.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
