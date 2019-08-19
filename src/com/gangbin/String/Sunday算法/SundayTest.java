package com.gangbin.String.Sunday算法;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/8/14
 */
public class SundayTest {
     static final int ASCII_SIZE = 126;
    public static int sunday(char[] total,char[] part){
        int tSize = total.length;
        int pSize = part.length;
        int[] move = new int[ASCII_SIZE];

        //主串参与匹配最末位字符移动到该位需要移动的位数
        for (int i= 0;i<ASCII_SIZE;i++){
            move[i] = pSize+1;      //如果不在模式串中，则右移Psize+1
        }


        for (int i = 0;i<pSize;i++){
            move[part[i]] = pSize-i;  //如果在模式串中，右移的位置为Psize-i
        }

        int s = 0;//模式串头部在字符串位置

        int j;//模式串已经匹配了的长度

        while(s<=tSize-pSize){//到达末尾之前
            j = 0;//每次都从0开始匹配
            while(total[s+j]==part[j]){
                j++;
                if (j>=pSize){
                    return s;
                }
            }
            s+=move[total[s+pSize]];//如果s+pSize在模式串中，则模式串右移PSize-i
            //如果不在，则整体右移到pSize+1位
        }
        return -1;
    }

    //注意每次都是从后向前
    public static int contains(char[] str,char ch){
        for(int i=str.length-1;i>=0;i--){
            if(str[i]==ch){
                return i;
            }
        }
        return -1;
    }
    public static void Sunday(String s,String p){
        char[] sarray = s.toCharArray();
        char[] parray = p.toCharArray();
        int slen=s.length();
        int plen=p.length();
        int i=0,j=0;
        while(i<=slen-plen+j){//这句话控制索引i,j的范围
            if(sarray[i]!=parray[j]){//假如主串的sarry[i]与模式串的parray[j]不相等
                if(i==slen-plen+j){//
                    break;//假如主串的sarry[i]与模式串的parray[j]不相等,并且i=slen-plen+j,说明这已经
                    //是在和主串中最后可能相等的字符段比较了,并且不相等,说明后面就再也没有相等的了,所以
                    //跳出循环,结束匹配
                }
                //假如是主串的中间字段与模式串匹配，且结果不匹配
                //则就从模式串的最后面开始,(注意是从后向前)向前遍历,找出模式串的后一位在对应的母串的字符是否在子串中存在
                int pos=contains(parray, sarray[i+plen-j]);
                if(pos==-1){//表示不存在
                    i=i+plen+1-j;
                    j=0;
                }else{
                    i=i+plen-pos-j;
                    j=0;
                }
            }else{//假如主串的sarry[i]与模式串的parray[j]相等,则继续下面的操作
                if(j==plen-1){//判断模式串的索引j是不是已经到达模式串的最后位置，
                    //j==plen-1证明在主串中已经找到一个模式串的位置,
                    //且目前主串尾部的索引为i,主串首部的索引为i-j,打印模式串匹配的第一个位置
                    System.out.println("the start pos is "+(i-j)+" the end pos is "+i);
                    //然后主串右移一个位置,再和模式串的首字符比较,从而寻找下一个匹配的位置
                    i=i-j+1;
                    j=0;
                }else{
                    //假如模式串的索引j!=plen-1,说明模式串还没有匹配完,则i++,j++继续匹配,
                    i++;
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str="1223456";
        String ptr="234";
        long time1=System.currentTimeMillis();
       // int ret=sunday(str.toCharArray(),ptr.toCharArray());
        Sunday(str,ptr);
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);

    }
}
