package com.gangbin.设计模式;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/16
 */
//线程安全，类加载时初始化
class Singleton{
    private static final Singleton instance=new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
//静态内部类
class Singleton1{
    private static class Instance{
        public static final Singleton singleton=new Singleton();
    }
    public static Singleton getInstance(){
        return Instance.singleton;
    }
}
//双重检测锁
class Singleton2{
    private static volatile Singleton instance=null;
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (instance){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}

enum Singleton3{
    INSTANCE;
    public static Singleton3 getInstance(){
        return INSTANCE;
    }
}
public class 单例模式 {
    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton1.getInstance();
        Singleton2.getInstance();
        Singleton3.getInstance();
    }

}
