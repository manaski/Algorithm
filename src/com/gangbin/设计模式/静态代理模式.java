package com.gangbin.设计模式;

/**
 * @author gangbin.li
 * @description: 代理类和被代理类要实现相同的接口
 * @date 2019/10/16
 */
//抽象主题
interface Subject
{
    void Request();
}
//真实主题
class RealSubject implements Subject
{
    public void Request()
    {
        System.out.println("访问真实主题方法...RealSubject");
    }
}
//代理
class Proxy implements Subject
{
    private Subject realSubject;//真实对象
    public void Request()
    {
        if (realSubject==null)
        {
            realSubject=new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }
    public void preRequest()
    {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void postRequest()
    {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
public class 静态代理模式 {
    public static void main(String[] args) throws InterruptedException {
        Proxy proxy=new Proxy();    //直接用代理对象来执行请求
        proxy.Request();
        Thread t=new Thread();
        t.join(100);
    }
}
