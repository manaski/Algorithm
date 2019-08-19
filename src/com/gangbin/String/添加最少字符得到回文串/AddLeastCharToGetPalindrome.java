package com.gangbin.String.添加最少字符得到回文串;

/**
 * 给定字符串，添加最少的字符使之成为回文串
 * 先确定字符串中添加多少字符可以变成回文串
 */
public class AddLeastCharToGetPalindrome {
    public static String minCharDp(String s){
        char[] c=s.toCharArray();
        int n=c.length;
        int [][]dp=new int[n][n];//对角线的肯定都是0
        for(int i=1;i<n;i++){
            dp[i-1][i]=c[i-1]==c[i]?0:1;   //相邻两个，分为两种情况
            for(int j=i-2;j>-1;j--){
                if(c[j]==c[i]){
                    dp[j][i]=dp[j+1][i-1];
                }else{
                    dp[j][i]=Math.min(dp[j+1][i],dp[j][i-1])+1;
                }
            }
        }
      //  System.out.println(dp[0][n-1]);
        return getPalindrome(c,dp);

    }
    //按照dp数组找到最后的回文字符串
    public static String getPalindrome(char[] c,int[][]dp){
        int l=0;
        int r=c.length-1;
        int len=c.length+dp[l][r];
        char[] res=new char[len];
        int indexl=0;
        int indexr=res.length-1;
        while(l<=r){
            if(c[l]==c[r]){
                res[indexl++]=c[l];
                res[indexr--]=c[l];
                l++;
                r--;
            }else{
                if(dp[l+1][r]<dp[l][r-1]){
                    res[indexl++]=c[l];
                    res[indexr--]=c[l];
                    l++;
                }else{
                    res[indexl++]=c[r];
                    res[indexr--]=c[r];
                    r--;
                }
            }
        }
        return String.valueOf(res);
    }
//进阶问题，如果知道最大回文子序列，提高时间复杂度
    //采用剥洋葱的方法，从外层向内一直循环
    //每一层把头尾不对称的部分连接和翻转
    public static String findPalindrome(String s,String lps){
        if(s==null||s.length()==0){
            return "";
        }
        char[] cs=s.toCharArray();
        char[] clps=lps.toCharArray();
        char[] res=new char[2*cs.length-clps.length];
      //  System.out.println(2*cs.length-clps.length);
        int lpsl=0;
        int lpsr=clps.length-1;
        int sl=0;
        int sr=cs.length-1;
        int resl=0;
        int resr=res.length-1;
        int lcopy=0;
        int rcopy=cs.length-1;
        while(lpsl<=lpsr){
        while(cs[sl]!=clps[lpsl]){
                sl++;
        }
        while(cs[sr]!=clps[lpsr]){
                sr--;
        }
        setRes(res,resl,resr,cs,lcopy,sl,sr,rcopy);
        resl=resl+(sl-lcopy+rcopy-sr);
        resr=resr-(sl-lcopy+rcopy-sr);
        res[resl++]=cs[sl++];
        res[resr--]=cs[sr--];
        lcopy=sl;
        rcopy=sr;
        lpsl++;
        lpsr--;
        }
        return String.valueOf(res);

    }
    public static void setRes(char[] res, int resl,int resr, char[] chars, int lfrom,int lto,int rfrom,int rto){
       for(int i=lfrom;i<lto;i++){
           res[resl++]=chars[i];
           res[resr--]=chars[i];
       }
        for(int i=rto;i>rfrom;i--){
            res[resr--]=chars[i];
            res[resl++]=chars[i];
        }
    }

    public static void main(String[] args) {
        String s="958641324875";  //5843485
        String res=minCharDp(s);
        System.out.println(res);
        res=findPalindrome(s,"5843485");
        System.out.println(res);
    }
}
