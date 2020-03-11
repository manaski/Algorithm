package com.gangbin.leetcode题目;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/11/1
 */
public class 排序数组 {

    public List<Integer> sortArray1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res=new LinkedList<>();
        for(int t:nums){
            res.add(t);
        }
        return res;

    }
    //快速排序
    public List<Integer> sortArray2(int[] nums) {
        List<Integer> res=new LinkedList<>();
        quick(nums,0,nums.length-1);
        for(int t:nums){
            res.add(t);
        }
        return res;
    }
    public  void quick(int[] nums, int begin, int end){
        int left=begin;
        int right=end;
        if(begin>=end){
            return;
        }
        int flag=nums[left];//选中一个标杆值
        while(left<right){
            while(left<right&&nums[right]>flag){
                right--;
            }
            while(left<right&&nums[left]<=flag){//前面这里加一个等于号，从最左边出发，
                // 如果直接从后面出发，当数组个数为2时，可能会造成栈溢出
                left++;
            }
            swap(nums,left,right);
        }
        swap(nums,begin, right);
        quick(nums,begin,left-1);
        quick(nums,left+1,end);
    }
    //双指针，适合于链表排序的
    public static void quickSort(int[] nums,int begin, int end){
        if(begin>end||begin==end){
            return;
        }
        int i=begin+1;
        int j=begin+1;
        int target=nums[begin];
        while(j<=end){
            if(nums[j]<target){
                swap(nums,i,j);
                i++;
                j++;
            }else{
                j++;
            }
        }
        swap(nums,begin,--i);
        quickSort(nums,begin,i-1);
        quickSort(nums,i+1,end);
    }


    //归并排序(从上往下)
    public static List<Integer> sortArray3(int[] nums) {
        List<Integer> res=new LinkedList<>();
        int[] arr=mergeSort(nums,0,nums.length-1);
        for(int t:arr){
            res.add(t);
        }
        return res;
    }
    //先拆分再合并
    public static int[] mergeSort(int[] nums, int begin, int end){
        if(begin>end){
            return new int[0];
        }
        if(begin==end){
            return new int[]{nums[begin]};
        }
        int m=begin+(end-begin)/2;
        int[] lres=mergeSort(nums,begin,m);
        int[] rres=mergeSort(nums,m+1,end);
        int[] res=new int[lres.length+rres.length];
        int i=0;
        int j=0;
        int index=0;
        while(i<lres.length&&j<rres.length){
            if(lres[i]<rres[j]){
                res[index++]=lres[i++];
            }else{
                res[index++]=rres[j++];
            }
        }
        while(i<lres.length){
            res[index++]=lres[i++];
        }
        while(j<rres.length){
            res[index++]=rres[j++];
        }
        return res;
    }
    //桶排序，先计数再排序
    public int[] bucketSort(int[] nums){
        if(nums==null||nums.length==0){
            return nums;
        }
        int low= Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            low=Math.min(low,nums[i]);
            high=Math.max(high,nums[i]);
        }
        int n=high-low+1;
        int[] buckets=new int[n];
        for(int t:nums){
            buckets[t-low]++;
        }
        int[] res=new int[nums.length];
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<buckets[i];j++){
                res[index++]=low+i;
            }
        }
        return res;
    }

    //插入排序，时间复杂度比较高
    public static void insertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int j=i-1;
            int target=nums[i];
            while(j>=0&&nums[j]>target){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=target;
        }
    }

    //希尔排序，是插入排序的一种变形，相隔gap进行插入
    public void shellSort(int[] nums) {
        for (int gap = nums.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; ++i) {
                for (int j = i; j - gap >= 0 && nums[j-gap]>nums[j]; j -= gap) {
                    swap(nums,j-gap, j);
                }
            }
        }
    }
    public static void swap(int[] nums, int i, int j){
        nums[i]=nums[j]^(nums[j]=nums[i])^nums[i];
    }


    //选择排序
    public void selectSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int min=i;
            for(int j=i;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            swap(nums,i, min);
        }
    }

    //冒泡排序，超时
    public void bubbleSort(int[] nums){
        boolean changed=false;
        for(int i=0;i<nums.length-1;i++){
            changed=false;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j+1, j);
                    changed=true;
                }
            }
            if(!changed){
                break;
            }
        }
    }
    //堆排序
    public static int[] heapSort(int[] nums) {
        buildHeap(nums);
        int size=nums.length;
       for(int i=0;i<nums.length-1;i++){
           swap(nums,0,size-1);
           size--;
           adjust(nums,0,size);
       }
       return nums;
    }
    //向堆中插入元素
    public static void insert(int[] arr,int index){
        int parent=0;
        while(index!=0){//根节点是没有父节点的
            parent=(index-1)/2;
            if(arr[parent]<arr[index]){
                swap(arr,parent,index);
            }
            index=parent;
        }
    }
    //建一个大顶堆
    public static void buildHeap(int[] arr){
        for(int i=1;i<arr.length;i++){
            insert(arr,i);
        }
        System.out.println(Arrays.toString(arr));
    }
    //从index开始调整大顶堆
    public static void adjust(int[] arr, int index, int size){
        int left=index*2+1;
        int right=index*2+2;
        int max=index;
        while(left<size){
            if(arr[left]>arr[max]){
                max=left;
            }
            if(right<size&&arr[right]>arr[max]){
                max=right;
            }
            if(max!=index){
                swap(arr,max,index);
            }else{
                break;
            }
            index=max;
            left=index*2+1;
            right=index*2+2;
        }
    }

    public static void main(String[] args) {
        int[] nums={5,1,1,2,0,0};
        //sortArray2(nums);
        //insertSort(nums);
        //heapSort(nums);
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
