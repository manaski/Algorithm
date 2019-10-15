package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/27
 */
public class 比特计数 {
    public int[] countBits(int num) {
        int[] res=new int[num];
        for(int i=1;i<=num;i++){
            res[i]=getCount(i);
        }
        return res;

    }
    public int getCount(int num){
        int count=0;
        while(num!=0){
            if((num&1)==1){
                count++;
            }
            num=num>>1;
        }
        return count;
    }
        public int[] countBit(int num) {
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i)
                ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
            return ans;
        }

}
