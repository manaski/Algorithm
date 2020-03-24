package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2020/3/19
 */
public class 用字母构成最长回文串 {
    public int longestPalindrome(String s) {
        //记录从大写字母到小写字母的个数  "A"-"Z"  "a"-"z"
        int[] nums=new int[52];
        for(int i=0;i<s.length();i++){
            char c;
            if((c=s.charAt(i))>='A'&&c<='B'){
                nums[c-'A']++;
            }else{
                nums[c-'a'+26]++;
            }
        }
        int maxLen=0;
        boolean flag=false;
        for(int i=0;i<52;i++){
            if(nums[i]%2==0){
                maxLen+=nums[i];
            }else{
                maxLen+=nums[i]-1;
                flag=true;
            }
        }
        return flag?maxLen+1:maxLen;
    }
}
