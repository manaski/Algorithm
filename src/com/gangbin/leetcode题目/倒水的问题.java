package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 若a, b是整数, 且gcd(a, b)=d，那么对于任意的整数x,y,ax+by都一定是d的倍数，特别地，一定存在整数x,y，使ax+by=d成立。
 * 本题先判断所需要的水量是否大于两个桶的容量之和，如果不大于，判断所需要的水量是否是两个桶容量的最大公约数的倍数，根据裴蜀定理可以证明：
 * 如果所需要的水量是两个水壶容量的最大公约数的倍数，且水量不大于两个水壶的容量之和，那么必然可以用这两个水壶操作得到所需要的水量。
 * @date 2019/10/29
 */
public class 倒水的问题 {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == 0 && y == 0) return z == 0;
        return z == 0 || (z % gcd(x,y) == 0 && x + y >= z);
    }
    static int gcd(int x,int y){
        if(y == 0) return x;
        int r = x % y;
        return gcd(y,r);
    }
    public static void main(String[] args) {
        System.out.println(gcd(13,2));
    }
}
