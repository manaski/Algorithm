package com.gangbin.实现HashMap;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/11
 */
public class MapTest {
    public static void main(String[] args) {
        MyHashMap<Integer,String> map=new MyHashMap<>();
        for(int i=0;i<100;i++){
            map.put(i,"name"+i);
        }
    }
}
