package com.gangbin.Company.字节跳动;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/11
 */
public class Main1 {
    public static int[] getTime(String lesson, int time, String[] alarm){
        String[] ls=lesson.split(" ");
        int lessonTime=Integer.valueOf(ls[0])*60+Integer.valueOf(ls[1]);
        int line=lessonTime-time;
        int[] alarmTime=new int[alarm.length];
        for (int i=0;i<alarm.length;i++){
            String[] ss=alarm[i].split(" ");
            alarmTime[i]=Integer.valueOf(ss[0])*60+Integer.valueOf(ss[1]);
        }
        int start=0;
        while(start<alarmTime.length&&alarmTime[start]<=line){
            start++;
        }
        int[] res=new int[2];
        res[0]=alarmTime[start-1]/60;
        res[1]=alarmTime[start-1]%60;
        return res;

    }
    public static void main(String[] args) {
        String lesson="6 59";
        int time=59;
        String[] alarm={"5 0","6 0","7 0"};
        int[] res=getTime(lesson,time,alarm);
        System.out.println(res[0]+" "+res[1]);
    }
}
