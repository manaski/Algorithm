package com.gangbin.Company.搜狗;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/9/8
 */
class MyMap extends HashMap {
    Map<String ,Integer> map;
    LinkedList<String> list;

    int size;
    MyMap(int size){
        this.size=size;
        map=new HashMap<>();
        list=new LinkedList<>();
    }
    public void put(String key, Integer value) {
        if(map.size()>=size){
            if(map.containsKey(key)){
                int r=map.get(key);
                if(r<value){
                    list.remove(key);
                    list.addFirst(key);
                    map.put(key,value);
                }
            }else{
                String oldkey=getOldest();
                System.out.println(oldkey+" "+map.get(oldkey));
                map.remove(oldkey);
                list.remove(oldkey);
                map.put(key,value);
                list.addFirst(key);
            }
        }else{
            if(map.containsKey(key)){
                int r=map.get(key);
                if(r<value){
                    list.remove(key);
                    list.addFirst(key);
                    map.put(key,value);
                }
            }else{
                map.put(key,value);
                list.addFirst(key);
            }
        }
    }

    public String getOldest(){
        return list.removeLast();
    }
}

class NewMap<K,V> extends LinkedHashMap<K,V>{
    private static int SIZE;
    NewMap(int size){
        super(size);
        SIZE=size;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>SIZE;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int n=Integer.valueOf(s);
        MyMap map=new MyMap(n);
        NewMap<String,Integer> map1=new NewMap<>(n);
        String str;
        while(scanner.hasNextLine()){
            str=scanner.nextLine();
            String[] ss=new String[2];
            ss=str.split(" ");
            map1.put(ss[0],Integer.valueOf(ss[1]));


        }

    }
}
