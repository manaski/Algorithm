package com.gangbin.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gangbin.li
 * @description: 代码
 * @date 2019/10/11
 */
public class ProxyTest {
    public static void main(String[] args) {
        Human man=new Person("lili");//被代理对象
        Human human=(Human) Proxy.newProxyInstance(Human.class.getClassLoader(), new Class[]{Human.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("进入到代理方法");
                System.out.println("方法名称为"+method.getName());
                Object res=method.invoke(man,args);
                System.out.println("方法被调用了");
                return res;
            }
        });
        human.dance();
        human.sing("hahaha");

    }
}
