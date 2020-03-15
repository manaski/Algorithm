package com.gangbin.leetcode题目;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if(len<1){
            return 0;
        }
         int max=0;
         int[]dp=new int[len];
         dp[0]=1;
         for(int i=0;i<len;i++){
             int maxV=0;
           for(int j=i-1;j>=0;j--){
               if(nums[j]<nums[i]){
                   maxV=Math.max(maxV,dp[j]);
               }
           }
           dp[i]=maxV+1;
           max=Math.max(max,dp[i]);
         }
         return max;
    }
    //贪心算法加二分查找
    public static int lengthOfLIS2(int[] nums){
        int len=nums.length;
        if(len<1){
            return 0;
        }
        int[] d=new int[len];
        int end=0;
        d[0]=nums[0];
        for(int i=1;i<len;i++){
            if(nums[i]>d[end]){
                d[end+1]=nums[i];
                end++;
            }else {
                int index=biSearch(d,end,nums[i]);
                d[index+1]=nums[i];
            }
        }
        return end+1;
    }
    public static int biSearch(int[] nums, int end, int n){
        int begin=0;
        int mid=0;
        if(n<=nums[0]){
            return -1;
        }
        while(begin<end){
            mid=(begin+end+1)/2;
            if(nums[mid]>=n){
                end=mid-1;
            }else if(nums[mid]<n){
                begin=mid;
            }
        }
        return end;
    }
    public static int binarySearch(int[] nums, int n){
        int begin=0;
        int end=nums.length-1;
        int mid=0;
        if(n<nums[0]||n>nums[end]){
            return -1;
        }
        while(begin<=end){
            mid=(begin+end)/2;
            if(nums[mid]==n){
                //相等的就返回对应下标
                return mid;
            }else if(nums[mid]>n){
                end=mid-1;
            }else if(nums[mid]<n){
                begin=mid+1;
            }
        }
        return -1;
    }
    /**
     *  查找小区域的边界
     */
    public static int binarySearch2(int[] nums, int n){
        int begin=0;
        int end=nums.length-1;
        /*首先要保证初始情况下能满足要求
        即begin和左边都是小于的，end和右边都是大于等于的
        */
        if(nums[0]>=n){
            return -1;
        }
        if(nums[end]<n){
            return end;
        }
        int mid=0;
        while(begin<end){
            mid=(begin+end+1)/2;
           if(nums[mid]>=n){
                end=mid-1;
            }else {
                begin=mid;
            }
        }
        return end;
    }
    /**
     *  查找大区域的边界
     */
    public static int binarySearch3(int[] nums, int n){
        int begin=0;
        int end=nums.length-1;
        /*
          首先要保证初始情况下能满足要求
          即begin和左边都是小于等于的，end和右边都是大于的
        */
        if(nums[0]>n){
            return 0;
        }
        if(nums[end]<=n){
            return end+1;
        }
        int mid=0;
        while(begin<end){
            mid=(begin+end)/2;
            if(nums[mid]>n){
                end=mid;
            }else {
                begin=mid+1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        int[] a={10,9,2,5,3,7,101,18};
        int[] b={110,112};
        int res=-1;
        //res=lengthOfLIS2(a);
        res=biSearch(b,b.length-1,113);
        System.out.println(res);

    }

}
