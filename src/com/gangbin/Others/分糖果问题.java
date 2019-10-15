package com.gangbin.Others;

/**
 * @author gangbin.li
 * @description: 如果相同的分数，分的糖果数可以不一样的时候，采用上下坡的方式实现
 * 如果相同的分数，分的糖果必须一样，进阶问题
 * 对左坡，在上升遍历时加上
 * 对右坡，找到下一个左坡起点，然后整体对右坡处理
 * @date 2019/9/11
 */
public class 分糖果问题 {
    public static int candy1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int index = nextMinIndex1(arr, 0);
        int res = rightCands(arr, 0, index++);
        int lbase = 1;
        int next = 0;
        int rcands = 0;
        int rbase = 0;
        while (index != arr.length) {
            if (arr[index] > arr[index - 1]) {
                res += ++lbase;    //上坡时一个一个的加
                index++;           //右移
            } else if (arr[index] < arr[index - 1]) {
                next = nextMinIndex1(arr, index - 1);
                rcands = rightCands(arr, index - 1, next++);
                rbase = next - index + 1;
                res += rcands + (rbase > lbase ? -lbase : -rbase);
                lbase = 1;
                index = next;
            } else {
                res += 1;
                lbase = 1;
                index++;
            }
        }
        return res;
    }

    public static int nextMinIndex1(int[] arr, int start) {
        for (int i = start; i != arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }

    public static int rightCands(int[] arr, int left, int right) {
        int n = right - left + 1;
        return n + n * (n - 1) / 2;
    }

    public static int candy2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int index = nextMinIndex2(arr, 0);//找到第一个上坡
        int[] data = rightCandsAndBase(arr, 0, index++);
        int res = data[0];
        int lbase = 1;
        int same = 1;
        int next = 0;
        while (index != arr.length) {
            if (arr[index] > arr[index - 1]) {//位于上坡时
                res += ++lbase;
                same = 1;
                index++;
            } else if (arr[index] < arr[index - 1]) {//开始下坡
                next = nextMinIndex2(arr, index - 1);//找到下一个上坡开始点
                data = rightCandsAndBase(arr, index - 1, next++);
                if (data[1] <= lbase) {
                    res += data[0] - data[1];//如果左坡比较高，减去多加的一个右坡高度
                } else {//右坡较高，把左坡减掉-lbase*same，加上右坡data[1]*same，
                    //减去多加的右坡 -data[1]，因为算右坡时加上顶端
                    res += -lbase * same + data[0] - data[1] + data[1] * same;
                }
                index = next;
                lbase = 1;
                same = 1;
            } else {
                res += lbase; //先把左边加上
                same++;//记录平坡宽度
                index++;
            }
        }
        return res;
    }

    public static int nextMinIndex2(int[] arr, int start) {
        for (int i = start; i != arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }

    public static int[] rightCandsAndBase(int[] arr, int left, int right) {
        int base = 1;//初始个数为1
        int cands = 1;//总数1
        for (int i = right - 1; i >= left; i--) {
            if (arr[i] == arr[i + 1]) {
                cands += base;//相等时加上当前基数
            } else {
                cands += ++base;//不相等，就是右坡度，基数++
            }
        }
        return new int[] { cands, base };
    }

    public static void main(String[] args) {
        int[] test1 = { 3, 0, 5, 5, 4, 4, 0 };
        System.out.println(candy1(test1));

        int[] test2 = { 3, 0, 5, 5, 4, 4, 0 };
        System.out.println(candy2(test2));
    }

}
