package com.gangbin.leetcode题目;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/20
 */
public class 滑动窗口最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k<1){
            return null;
        }
        if(k==1){
            return nums;
        }
        LinkedList<Integer> queue=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(queue.isEmpty()){
                queue.offer(i);
                continue;
            }
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
                    queue.pollLast();
            }
            queue.offerLast(i);

            if(queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            if(i>=k-1){
              //  System.out.println(queue.peek());
                res.add(queue.peekFirst());
            }
        }
        int[] ret=new int[res.size()];
        for(int i=0;i<res.size();i++){
          //  System.out.println(res.get(i));
            ret[i]=nums[res.get(i)];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{7,2,4};
        int k=2;
        maxSlidingWindow(nums,k);
    }
}
