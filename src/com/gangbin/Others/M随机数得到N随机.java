package com.gangbin.Others;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/14
 */
public class M随机数得到N随机 {
    public static int getRand(int m){
        return (int) (Math.random()*m)+1;
    }
    public static void getRand(int m, int n){
        int[] rm=toMjinzhi(n,m);
        int[] res=getNumfromM(rm,m);
        int ret=getNumFromM(res,m);
        System.out.println(ret);
    }
    //生成M进制的随机数
    public static int[] getNumfromM(int[] mjinzhi, int m){
        boolean isEqual=true;
        int[] res=new int[mjinzhi.length];
        int start=0;
        while(mjinzhi[start]==0){
            start++;
        }
        int index=start;
        while(index<mjinzhi.length){
            res[index]=getRand(m)-1;
         //   System.out.println(res[index]);
            if(isEqual){
                if(res[index]>mjinzhi[index]){   //如果大于最大数，重新生成
                    index=start;
                    continue;
                }else{
                    isEqual=res[index]==mjinzhi[index];//如果相等就要比较
                }
            }
            index++;
        }
     //   System.out.println(Arrays.toString(res));
        return res;
    }
    //将要转化的数字转为M进制
    public static int[] toMjinzhi(int n,int m){
        int[] res=new int[32];
        int index=res.length-1;
        while(n!=0){
            res[index--]=n%m;
            n=n/m;
        }
      //  System.out.println(Arrays.toString(res));
        return res;
    }
    public static int getNumFromM(int[] mjinzhi,int m){
        int res=0;
        int index=mjinzhi.length-1;
        int cur=1;
        while(mjinzhi[index]!=0){
             res+=cur;
             cur=cur*m;
             index--;
        }
      //  System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int n=10;
        int m=3;
        while(true){
            getRand(m,n);
        }

    }
}
