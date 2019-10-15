package com.gangbin.实现HashMap;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/11
 */

public class MyHashMap<V,T> {

    private static final int INITIAL_SIZE=16;

    private int capacity=16;

    private int size=0;

    private static final double loadFactor=0.75;

    Entry<V,T>[] table=null;

    public void put(V key, T value){
        Entry<V,T> node=new Entry<>(key,value);
        if(table==null){
            table=new Entry[INITIAL_SIZE];
        }
        if(capacity*loadFactor<=size){
            resize();
        }
        int index=getIndex(key,capacity);
        Entry<V,T> e=table[index];
        if(e==null){
            table[index]=node;
            return;
        }else{
            Entry<V,T> f=null;
            while(e!=null){
                if(e.hashCode()==node.hashCode()){
                    if(e.equals(node)){
                        e.value=node.value;
                        return;
                    }
                }
                f=e;
                e=e.next;
            }
            f.next=node;
            size++;
        }

    }
    public T get(V key){
        int index=getIndex(key,capacity);
        Entry<V,T> e=table[index];
        while(e!=null){
            if(e.hashCode()==key.hashCode()&&e.equals(key)){
                return e.value;
            }
        }
        return null;
    }
    public void resize(){
        int cap=0;
        if(capacity>=Integer.MAX_VALUE/2){
            cap=Integer.MAX_VALUE;
        }else{
            cap=capacity*2;
        }
        Entry<V,T>[] newTable=new Entry[cap];
        Entry<V,T> f=null;
        Entry<V,T> h=null;
        Entry<V,T> l=null;
        Entry<V,T> rh=null;
        Entry<V,T> rl=null;
        for(int i=0;i<capacity;i++){
            f=table[i];
            l=newTable[i];
            h=newTable[i+capacity];
            while(f!=null){
                int index=getIndex(f.key,cap);
                if(index>=capacity){
                    if(h==null){
                        rh=f;
                        h=f;
                    }else{
                        h.next=f;
                        h=h.next;
                    }
                }else{
                    if(l==null){
                        rl=f;
                        l=f;
                    }else{
                        l.next=f;
                        l=l.next;
                    }
                }
                f=f.next;
            }
            if(l!=null){
                l.next=null;
            }
           if(h!=null){
               h.next=null;
           }

            newTable[i]=rl;
            newTable[i+capacity]=rh;
        }
        capacity=cap;
    }
    private int size(){
        return size;
    }
    private boolean isEmpty(){
        return size==0;
    }

    private int getIndex(V key,int capacity){
        return key.hashCode()&(capacity-1);
    }

    class Entry<V,T> {
        V key;
        T value;
        Entry<V,T> next=null;
        public Entry(V key, T value) {
            this.key = key;
            this.value = value;
        }
        private V getKey(){
            return key;
        }
        private T getValue(){
            return value;
        }
    }
}
