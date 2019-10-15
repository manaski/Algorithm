package com.gangbin.Company.流利说;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/11
 */
public class Main {

    static int minPath=Integer.MAX_VALUE;

    public static int getPath(int[][] arr,int x1,int y1,int x2,int y2) {
        int len1=arr.length;
        int len2=arr[0].length;
        int[][]visit=new int[len1][len2];
        process(arr,visit,x1, y1, x2, y2, 0);
        return minPath;
    }
    public static void process(int[][] arr,int[][] visit,int x1,int y1,int x2,int y2,int pathlen){
        int len1=arr.length;
        int len2=arr[0].length;
        if(x1==x2&&y1==y2){
            minPath=Math.min(minPath,pathlen);
        }
        visit[x1][y1]=1;
        if(x1-1>=0&&arr[x1-1][y1]!=1&&visit[x1-1][y1]==0){
            process(arr,visit,x1-1,y1,x2,y2,pathlen+1);
        }
        if(x1+1<len1&&arr[x1+1][y1]!=1&&visit[x1+1][y1]==0){
            process(arr,visit,x1+1,y1,x2,y2,pathlen+1);
        }
        if(y1-1>=0&&arr[x1][y1-1]!=1&&visit[x1][y1-1]==0){
            process(arr,visit,x1,y1-1,x2,y2,pathlen+1);
        }
        if(y1+1<len2&&arr[x1][y1+1]!=1&&visit[x1][y1+1]==0){
            process(arr,visit,x1,y1+1,x2,y2,pathlen+1);
        }
        visit[x1][y1]=0;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (!s.equals("")) {
                list.add(s);
            } else {
                break;
            }
        }
        int x1=-1;
        int y1=-1;
        int x2=-1;
        int y2=-1;
        int m = list.size();
        String[] ss = list.get(0).split(" ");
        int n = ss.length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
             ss = list.get(i).split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.valueOf(ss[j]);
                if(arr[i][j]==2){
                    x1=i;y1=j;
                }
                if(arr[i][j]==3){
                    x2=i;y2=j;
                }
            }
        }
//        for(int[] p:arr){
//            System.out.println(Arrays.toString(p));
//        }
        int ret=getPath(arr,x1,y1,x2,y2);
        System.out.println(ret);

    }

}
