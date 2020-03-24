package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/21
 */
public class 安排电影院座位 {
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats,(o1,o2)->o1[0]-o2[0]);
        boolean[] seats=new boolean[10];

        int cnt=0;
        int index=0;
        int num=reservedSeats[0][0]-1;
        for(int i=0;i<n;i++){
            if(index<reservedSeats.length&&reservedSeats[index][0]==i+1){
                Arrays.fill(seats,true);
                while(index<reservedSeats.length&&reservedSeats[index][0]==i+1){
                    seats[reservedSeats[index][1]-1]=false;
                    index++;
                }
                cnt+=findSeats(seats);
            }else{
                if(index>=reservedSeats.length){
                    cnt+=2*(n-i);
                    break;
                }else{
                    cnt+=2;
                }

            }
        }
        return cnt;
    }
    public static int findSeats(boolean[] seats){
        int cnt=0;
        if(seats[1]&&seats[2]&seats[3]&&seats[4]){
                cnt++;
        }
        if(cnt==0){
            if(seats[3]&&seats[4]&seats[5]&&seats[6]){
                cnt++;
            }
        }else{
            if(seats[5]&&seats[6]&seats[7]&&seats[8]){
                cnt++;
            }
        }
        if(cnt==0&seats[5]&&seats[6]&seats[7]&&seats[8]){
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] reservedSeats = {{4,3},{1,4},{4,6},{1,7}};
        int n=4;
        int res=maxNumberOfFamilies(n,reservedSeats);
        System.out.println(res);
    }
}
