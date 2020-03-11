package com.gangbin.leetcode题目;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/11/4
 */
public class 视频剪辑 {
    public static int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips,((o1, o2) -> o1[0]-o2[0]));
        int count=1;
        int end=0;
        int i=0;
        int begin=0;
        while(i<clips.length&&end<T){
            if(clips[i][0]>begin&&clips[i][1]>end){
                if(clips[i][0]>end){ //如果超过当前最右边界，说明不可完成
                    break;
                }
                count++;
                begin=end;
            }
            end=Math.max(end,clips[i][1]);
            i++;
        }
        return end<T?-1:count;
    }

    public static void main(String[] args) {
        int[][] arr={{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        videoStitching(arr,10);
    }
}
