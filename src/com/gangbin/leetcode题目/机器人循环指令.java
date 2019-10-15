package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/24
 */
public class 机器人循环指令 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int posx=0;
        int posy=0;
        if(command==null||command.length()==0){
            return x==0&&y==0;
        }
        int len=command.length();
        int step=0;
        while(true){
            if(posx==x&&posy==y){
                return true;
            }
            if(obstacles!=null&&posx<obstacles.length&&posy<obstacles[0].length&&obstacles[posx][posy]==1){
                return false;
            }
            Character c=command.charAt(step%len);
            if(c.equals('R')){
                posx+=1;
            }else{
                posy+=1;
            }
            step++;
        }
    }
}
