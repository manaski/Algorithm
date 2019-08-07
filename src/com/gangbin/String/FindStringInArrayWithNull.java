package com.gangbin.String;

/**
 * 找到有序数组中字符串出现的最早的位置
 * 数组中可能存在null
 * 关键在于想到用二分查找的思想
 */
public class FindStringInArrayWithNull {
    public static int findPosition(String[] c,String s){
       if(s==null||c==null||c.length==0){
           return -1;
       }
       int res=-1;
       int left=0;
       int right=c.length-1;
       int mid=0;
       int i=0;
       while(left<=right){
           mid=left+(right-left)/2;
           if(c[mid]!=null&&c[mid].equals(s)){
               res=mid;
               right=mid-1;         //继续向左寻找更小的值
           }else if(c[mid]!=null){
               if(c[mid].compareTo(s)>0){
                   right=mid-1;
               }else{
                   left=mid+1;
               }
           }else{
               i=mid;
               //先往左边找，找到一个不为空的
               while(c[i]==null&&--i>=left);
               //如果找不到则将范围变为右边
               if(i<left||c[i].compareTo(s)<0){
                   left=mid+1;
               }else{
                   res=c[i].equals(s)?i:res;//如果相等得到一个结果
                   right=i-1;     //继续向左寻找更小的值
               }
           }
       }
        return res;
    }

}
