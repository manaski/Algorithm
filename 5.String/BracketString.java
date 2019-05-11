package com.zuo.exercise5_string;

/**
 * 判断是否满足括号匹配
 * 寻找最长的括号串
 */
public class BracketString {
    public static boolean isValid(String s){
        if(s==null||s.length()==0||s.length()%2==1){
            return false;
        }
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='('&&s.charAt(i)!=')'){
                return false;
            }
            if(s.charAt(i)=='('){
                num++;
            }
            if(s.charAt(i)==')'){
                if(num<=0){
                    return false;
                }else{
                    num--;
                }
            }
        }
        return num==0;
    }
public static int getLong(String s){
    if(s==null||s.length()==0){
        return 0;
    }
    char[] c=s.toCharArray();
    int[] dp=new int[c.length];
     int pre=0;
     int res=0;
     for(int i=0;i<c.length;i++){
         if(c[i]==')'){
             pre=i-dp[i-1]-1;
             if(pre>0&&c[pre]=='('){ //右括号的情况不考虑，因为如果是右括号，又不包括在dp[i-1]中，说明这个右括号无法匹配
              dp[i]=dp[i-1]+2+(pre>0?dp[pre-1]:0);
             }
         }
         res=Math.max(res,dp[i]);
     }
     return res;

}

    public static void main(String[] args) {
        String s="()((())()())";
        System.out.println(isValid(s));
    }

}
