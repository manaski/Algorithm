package com.gangbin.String.返回最长有效括号串;

/**
 * 判断是否满足括号匹配
 * 寻找最长的括号串
 */
public class BracketString {
    //判断某个括号串是否匹配
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
    //返回最长有效括号子串
public static int getLong(String s){
    if(s==null||s.length()==0){
        return 0;
    }
    char[] c=s.toCharArray();
    int[] dp=new int[c.length];//表示必须以i结尾的子串的最长括号串长度
     int pre=0;
     int res=0;
     for(int i=1;i<c.length;i++){
         if(c[i]==')'){
             pre=i-dp[i-1]-1;   //找到前面一个不是括号串的字符位置
             if(pre>=0&&c[pre]=='('){ //右括号的情况不考虑，因为如果是右括号，又不包括在dp[i-1]中，说明这个右括号无法匹配
              dp[i]=dp[i-1]+2  //这样可以加上两个头尾
                      +(pre>0?dp[pre-1]:0); //如果前面还有的话，可以继续添加到达最大
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
