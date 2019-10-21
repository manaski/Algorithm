package com.gangbin.leetcode题目;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/17
 */
public class 会议室问题2 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null||intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        PriorityQueue<PriorityQueue<Integer>> queues=new PriorityQueue<>(Comparator.comparingInt(o->o.peek()));
        queues.add(new PriorityQueue<>((o1,o2)->o2-o1));
        int count=1;
        for(int i=0;i<intervals.length;i++){
                int j=0;
                for(PriorityQueue<Integer> q:queues){
                    if(q.isEmpty()||q.peek()<=intervals[i][0]){
                        q.offer(intervals[i][1]);
                        break;
                    }
                    j++;
                }
                if(j==count){
                    PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->o2-o1);
                    queue.offer(intervals[i][1]);
                    queues.add(queue);
                    count++;
                }
            }

        return count;
    }
}
