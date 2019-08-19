package com.gangbin.Company.小红书;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 薯队长来到了迷宫的尽头，面前出现了N只魔物，Hi表示第i只魔物的血量，
 * 薯队长需要在T个回合内击败所有魔物才能获胜。每个回合薯队长可以选择物理攻击一只魔物，
 * 对其造成1点伤害（物理攻击次数无上限）;  或者消耗1点法力释放必杀技对其造成固定X点伤害
 * （薯队长开始拥有M点法力）。问X至少多大，薯队长才有机会获胜；如果无论如何都无法在T回
 * 合内获胜，则输出-1
 * 方法：二分查找方法
 * @date 2019/8/18
 */
public class Main4 {

   public static boolean check(int n, int t, int m, int mn, PriorityQueue<Integer> data, long sum) {
        while (!data.isEmpty()) {
            if (m>0) { //当还有魔法值的时候
                Integer pre = data.poll();
                sum -= pre;   //记录总数，为了在魔法值消失时和回合数做比较
                if (pre > mn) {//如果不能一次用魔法值完成
                    int md = Math.min(pre / mn, m);
                    data.offer(pre - md * mn);
                    System.out.println(data);
                    sum += pre - md * mn;
                    m -= md;
                    t -= md;
                } else{//一次魔法可以完成
                    m--;
                    t--;
                }
                if (t < 0) return false;//回合数小于0
            } else {//当魔法值已经用完
                if (sum > t) return false;//如果剩下的物理值可以完成所有攻击
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int T=scanner.nextInt();
        int M=scanner.nextInt();
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->o2-o1);
        int count=0;
        int data;
        for(int i=0;i<N;i++){
            data=scanner.nextInt();
            queue.offer(data);
            count+=data;
        }
        int l=0;
        int r=queue.peek();     //合适的值范围处于0和最大魔值
        while (l < r) {
            int mid = (l + r)>> 1;
            if (check(N, T, M, mid, queue, count)) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
}
