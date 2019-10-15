package com.gangbin.Company.爱奇艺;

/**
 * @author gangbin.li
 * @description: 01序列表示递增或递减的要求，最多有几种排列？
 * @date 2019/9/8
 */
public class Main2 {


        public static int numPermsDISequence(String S) {
            int res = 0;
            int n = S.length();
            int M = 1000000000+ 7;
            int[][] dp=new int[n+1][n+1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j <= i; ++j) {
                    if (S.charAt(i-1) == 'D') {   //前面是比较大的数字的组合
                        for (int k = j; k <= i - 1; ++k) {  //0-i-1的数字组成的排列中以j结尾的
                            dp[i][j] = (dp[i][j] + dp[i-1][k]) % M;
                        }
                    } else {
                        for (int k = 0; k <= j - 1; ++k) {
                            dp[i][j] = (dp[i][j] + dp[i-1][k]) % M;
                        }
                    }
                }
            }
            for (int i = 0; i <= n; ++i) {
                res = (res + dp[n][i]) % M;   //结果在最后一行加
            }
            return res;
        }

      public static int numPermsDISequence(int[] arr) {
                  int n = arr.length;
                  int Mod = 1000000000 + 7;
            int[][] dp=new int[n+1][n+1];     // 表示长度为i的排列中最后一位是剩余元素中第j小的
            for (int j = 0; j <= n; ++j) {
                dp[0][j] = 1;
            }
            for (int i = 0; i < n; ++i) {
                if (arr[i]== 0) {   //表示要增大
                    int  num = 0;
                    for (int j = 0; j < n - i; ++j) {
                        num = (num + dp[i][j]) % Mod;    //表示以小于j的数字结尾的所有组合数相加
                        dp[i + 1][j] = num;     //在累加过程中，更新前面的
                        //dp[i + 1][j]=dp[i + 1][j-1]+dp[i][j-1];
                    }
                } else {   //要减少
                    int num = 0;
                    for (int j = n - 1 - i; j >= 0; --j) {
                         num = (num + dp[i][j + 1]) % Mod;
                         dp[i + 1][j] = num;
                         // dp[i + 1][j]=dp[i+1][j+1]+dp[i][j + 1]
                    }
                }
            }
            return dp[n][0];
        }


    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] arr=new int[n-1];
//        for(int i=0;i<n-1;i++){
//            arr[i]=sc.nextInt();
//        }
//        System.out.println(Arrays.toString(arr));
//        int[] brr={1,1,0};
     //   int ret=numPermsDISequence(arr);
     //   System.out.println(ret);
        char c='A'+1;
        System.out.println(c);

    }

}
