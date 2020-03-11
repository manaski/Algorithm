package com.gangbin.leetcode题目;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/11/2
 */
class User{
    User(){
    }
    int playId;
    int score;
    User(int playId,int score){
        this.playId=playId;
        this.score=score;
    }

    @Override
    public String toString() {
        return "User{" +
                "playId=" + playId +
                ", score=" + score +
                '}';
    }
}
class Leaderboard {
    Map<Integer,User> map=new HashMap<>();
    List<User> list=new ArrayList<>();
    PriorityQueue<User> queue=new PriorityQueue<>((o1,o2)->o2.score-o1.score);
    public Leaderboard() {

    }
    public void addScore(int playerId, int score) {
        if(map.containsKey(playerId)){
            User user=map.get(playerId);
            user.score+=score;
            queue.remove(user);
            queue.add(user);
        }else{
            User u=new User(playerId,score);
            map.put(playerId,u);
            queue.add(u);
        }
       // System.out.println(queue);
        for(User u:queue){
            System.out.println(u);
        }
        System.out.println("-----------------");
    }

    public int top(int K) {
        int sum=0;
        int count=0;
        Iterator it=queue.iterator();
        while(it.hasNext()&&count<K){
            User user=(User) it.next();
            sum+=user.score;
            count++;
        }
        return sum;
    }
    public void reset(int playerId) {
        User user=map.get(playerId);
        user.score=0;
        queue.remove(user);
        queue.add(user);
        for(User u:queue){
            System.out.println(u);
        }
        System.out.println("-----------------");
    }
}
public class 排行榜 {
    public static void main(String[] args) {
        Leaderboard leaderboard=new Leaderboard();
        leaderboard.addScore(1,1);
        leaderboard.addScore(2,2);
        leaderboard.addScore(3,3);
        leaderboard.addScore(4,4);
        System.out.println(leaderboard.top(3));
        leaderboard.reset(3);
        System.out.println(leaderboard.top(3));
        leaderboard.addScore(2,4);
        System.out.println(leaderboard.top(1));
        System.out.println(leaderboard.top(2));
        System.out.println(leaderboard.top(4));
    }
}
