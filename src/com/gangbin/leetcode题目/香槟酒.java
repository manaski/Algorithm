package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/27
 */
public class 香槟酒 {
    public double ChampagneTower(int poured, int query_row, int query_glass)
    {
        double[][] TowerState = new double[100][];
        for (int i = 0; i < 100; i++)
        {
            TowerState[i] = new double[i + 1];
        }

        TowerState[0][0] = poured;
        for (int i = 0; i < 99; i++)
        {
            if(i>query_row){
                break;
            }
            for (int j = 0; j <= i; j++)
            {
                if (TowerState[i][j] > 1)
                {
                    double drop = TowerState[i][j] - 1;
                    TowerState[i][j] = 1;
                    TowerState[i + 1][j] += drop / 2;
                    TowerState[i + 1][j + 1] += drop / 2;
                }
            }
        }
        return TowerState[query_row][query_glass];
    }
}
