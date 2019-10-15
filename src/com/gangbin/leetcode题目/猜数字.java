package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/24
 */
public class 猜数字 {
    public int game(int[] guess, int[] answer) {
        int count=0;
        for(int i=0;i<guess.length;i++){
            if(guess[i]==answer[i]){
                count++;
            }
        }

        return count;

    }
}
