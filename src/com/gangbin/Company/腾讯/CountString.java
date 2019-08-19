package com.gangbin.Company.腾讯;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author gangbin.li
 * @description: 给定一个仅由小写字母组成且长度不超过10^6的字符串，
 * 将首字符移到末尾并记录所得的字符串，不断重复该操作，虽然记录了无
 * 限个字符串，但其中不同字符串的数目却是有限的，那么一共记录了多少
 * 个不同的字符串？
 * @date 2019/8/14
 */
public class CountString {
    /**
     * 1.利用kmp算法的next数组，可以求出字符串的最小循环周期T
     * 2.对字符串不断进行重组，对不同的字符串进行入队，最后返回队列的大小即为不同的字符串个数
     * @param str
     * @return
     */
    public static int getResult(String str){
        int len = str.length();
        int [] next = new int[len+1];
        next[0] = -1;
        int k = -1;
        int j  = 0;
        // 构建next数组
        while (j < len ){
            if(k== -1 || str.charAt(k) == str.charAt(j)){
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
        int res = len % (len - next[len]);
        if(res != 0)
            return len;
        else
            return len-next[len];
    }

    public static void main(String[] args) {
        String s="123123";
        System.out.println(getResult(s));
        System.out.println(new Float(2.2).equals(new Float(2.20)));

    }

}
