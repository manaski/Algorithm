package com.gangbin.字节跳动;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/15
 */
public class Main {
    public static int calculate(int[] arr, int k){
        Arrays.sort(arr);
        int res=0;
        int len=arr.length;
        int start=0;
        int end=len-1;
        int count=0;
        for(int i=0;i<len;i++){
            start=i+1;
            end=len-1;
            while (start<end){
                int s=arr[start]+arr[end]+arr[i];
                if(s>= k){
                    end--;
                }else{
                    count+=end-start;
                    start++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
    public static List<List<Integer>> calculate2(int[] arr){
        Arrays.sort(arr);
        int len=arr.length;
        int start=0;
        int end=len-1;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<len;i++){
            while(i>0&&arr[i]==arr[i-1]){
                i++;
            }
            start=i+1;
            end=len-1;
            while (start<end){
                int s=arr[start]+arr[end]+arr[i];
                if(s==0){
                    ArrayList<Integer> list1=new ArrayList<>();
                    list1.add(arr[i]);
                    list1.add(arr[start]);
                    list1.add(arr[end]);
                    res.add(list1);
                        while(start<end&&arr[start+1]==arr[start]){
                            start++;
                        }
                        while(end>start&&arr[end-1]==arr[end]){
                            end--;
                        }
                        start++;
                        end--;

                }else if(s>0){
                        end--;
                }else{
                        start++;
                }
            }
        }
        System.out.println(res);
        return res;
    }
    public static int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int len=arr.length;
        int start=0;
        int end=len-1;
        int res=Integer.MAX_VALUE;
        int ret=0;
        for(int i=0;i<len;i++){
            while(i>0&&arr[i]==arr[i-1]){
                i++;
            }
            start=i+1;
            end=len-1;
            while (start<end){
                int s=arr[start]+arr[end]+arr[i];
                if(s==target){
                  res=s;
                  return s;
                }else if(s>target){
                    if(s-target<res){
                        ret=s;
                        res=s-target;
                    }
                    end--;
                }else{
                    if(-s+target<res){
                        ret=s;
                        res=-s+target;
                    }
                    start++;
                }
            }
        }
        System.out.println(ret);
        return ret;
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        //String s=sc.nextLine();
//        int n=sc.nextInt();
//        int[] arr=new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//        }
//        int k=sc.nextInt();
        //calculate(arr,k);
        int[] arr={-1,2,1,-4};
        threeSumClosest(arr,1);
    }
}
