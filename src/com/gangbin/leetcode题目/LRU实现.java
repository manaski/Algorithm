package com.gangbin.leetcode题目;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/21
 */
class LRUCache1 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache1(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}

class LRUCache {
    int capacity=0;
    LinkedList<Integer> list=null;
    HashMap<Integer,Integer> map=null;

    public LRUCache(int capacity) {
         list=new LinkedList<>();
         map=new HashMap<>();
         this.capacity=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            list.remove(new Integer(key));
            list.add(key);
            return map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            list.remove(new Integer(key));
            list.addFirst(key);
        }else{
            if(map.size()>=capacity){
                map.put(key,value);
                map.remove(list.getLast());
                list.add(new Integer(key));
                list.removeLast();
            }else{
                map.put(key,value);
                list.add(new Integer(key));
            }
        }
    }
}
public class LRU实现 {

    public static void main(String[] args) {
          LRUCache1 obj = new LRUCache1(2);
       //   System.out.println(obj.get(1)+" "+obj.size());
          obj.put(1,1);
       // System.out.println(obj.get(1)+" "+obj.size());
        obj.put(2,2);
        System.out.println(obj.get(1)+" "+obj.size());
        obj.put(3,3);
        System.out.println(obj.get(2)+" "+obj.size());
        obj.put(4,4);
        System.out.println(obj.get(1)+" "+obj.size());
    }
}
