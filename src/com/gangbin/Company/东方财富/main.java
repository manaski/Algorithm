package com.gangbin.Company.东方财富;

/**
 * @author gangbin.li
 * @description: ${description}
 * @date 2019/8/4
 */
public class main {
    public static String getLongestString(String s1,String s2){
        if(s1==null||s2==null){
            return "";
        }
        if(s1.length()==0||s2.length()==0){
            return "";
        }
        int len1=s1.length();
        int len2=s2.length();
        int maxi=0;
        int maxj=0;
        int maxlen=0;
        int[][] dp=new int[len1][len2];
        for(int i=0;i<len1;i++){
            if(s1.charAt(i)==s2.charAt(0)){
                dp[i][0]=1;
            }
        }
        for(int i=0;i<len2;i++){
            if(s2.charAt(i)==s1.charAt(0)){
                dp[0][i]=1;
            }
        }
        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>maxlen){
                    maxi=i;
                    maxj=j;
                    maxlen=dp[i][j];
                }
            }
        }
        if(maxlen>0){
            return String.copyValueOf(s1.toCharArray(),maxi-maxlen+1,maxlen);
        }else{
            return "";
        }

    }

    public static void main(String[] args) {
        String s1="asd12345qwer";
        String s2="asdd1234_5qwerfff";
        String s=getLongestString(s1,s2);
        System.out.println(s);

    }

}
