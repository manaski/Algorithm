package com.gangbin.leetcode题目;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/30
 */
class Project{
    int profit;
    int capital;

    public Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}
public class IPO项目 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int len=Profits.length;
        Project[] projects=new Project[len];
        for(int i=0;i<len;i++){
            projects[i]=new Project(Profits[i],Capital[i]);
        }
        Arrays.sort(projects,(o1,o2)->o1.capital-o2.capital);
        PriorityQueue<Project> queue=new PriorityQueue<>((o1,o2)->o2.profit-o1.profit);
        int j=0;
        for(int i=0;i<k;i++){
            while(j<len&&projects[j].capital<=W){
                queue.offer(projects[j]);
                j++;
            }
            W=W+queue.poll().profit;
        }
        return W;
    }
}
