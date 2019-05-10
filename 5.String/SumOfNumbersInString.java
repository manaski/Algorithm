package com.zuo.exercise5_string;

public class SumOfNumbersInString {
    public static long getSum(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        int i=0;
        long res=0;
        long sum=0;
        boolean isPos=true;
        for(i=0;i<s.length();i++){
            //如果是数字记录值
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                res=10*res+s.charAt(i)-'0';
            }else if((isPos||s.charAt(i-1)=='-')&&s.charAt(i)=='-'){//当是连续出现的-或者第一次出现时
                   isPos=!isPos;
            }else{
                if(res>0||!isPos){       //当值为正或者符号不为正，置位
                    sum+=isPos?res:-res;
                    res=0;              //置位
                    isPos=true;
                }
                if(s.charAt(i)=='-'){//当前符号为-，最后把符号变一下
                    isPos=!isPos;
                }
            }
        }
        if(res>0){
            sum+=isPos?res:-res;
        }
        return sum;
    }

    public static int numSum(String str){
        if(str==null){
            return 0;
        }
        char[] charArr=str.toCharArray();
        int res=0;
        int num=0;
        boolean posi=true;
        int cur=0;
        for(int i=0;i<charArr.length;i++){
            cur=charArr[i]-'0';
            if(cur<0||cur>9){
                res+=num;
                num=0;
                if(charArr[i]=='-'){
                    if(i-1>-1&&charArr[i-1]=='-'){
                        posi=!posi;
                    }else
                    {
                        posi=false;
                    }
                }else{
                    posi=true;
                }
            }else{
                 num=num*10+(posi?cur:-cur);
            }
        }
        res=res+num;
        return res;
    }
    public static void main(String[] args) {
        String s="---1---2=-a--ds45op--6--";
        System.out.println(getSum(s));
        System.out.println(numSum(s));
    }
}
