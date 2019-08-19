package com.gangbin.Company.分发糖果;

import java.util.Arrays;

/**
 * @author gangbin.li
 * @description: 按照学生评分分发糖果的问题
 * @date 2019/8/14
 */
public class Candy {
    /**
     * 两次遍历，用两个数组分别记录满足左边条件和右边条件的数量，最后取比较大的一个值
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int []left=new int[ratings.length];
        int []right=new int[ratings.length];
        int []candys=new int[ratings.length];
        // 初始化糖果数组
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        Arrays.fill(candys,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]&&left[i]<=left[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&right[i]<=right[i+1]){
                right[i]=right[i+1]+1;
            }
        }
        int sum=0;
        // 两个数组中找到最大的
        for(int i=0;i<candys.length;i++){
            candys[i]=Math.max(left[i],right[i]);
            sum+=candys[i];
        }
        System.out.println(Arrays.toString(candys));
        return sum;

    }


        public static int count(int n) {
            return (n * (n + 1)) / 2;
        }
        public static int candy3(int[] ratings) {
            if (ratings.length <= 1) {
                return ratings.length;
            }
            int candies = 0;
            int up = 0;
            int down = 0;//记录上升和下降的高度
            int old_slope = 0;  //记录上一次是上升还是下降
            for (int i = 1; i < ratings.length; i++) {
                int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
                //当达到顶点或低谷时，计算高度
                if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                    candies += count(up) + count(down) + Math.max(up, down);
                    up = 0;
                    down = 0;
                }
                if (new_slope > 0)
                    up++;
                if (new_slope < 0)
                    down++;
                if (new_slope == 0)//如果是
                    candies++;

                old_slope = new_slope;
            }
            candies += count(up) + count(down) + Math.max(up, down) + 1;
            return candies;
        }


    public static void main(String[] args) {
        int[] range={1,2,3,3,2,1};
     //   int res=candy3(range);
       // System.out.println(res);
        System.out.println(10%7);
    }
}
