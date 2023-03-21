package com.zdh.study.ui.design.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/21 10:32
* description:动态代理类
* 定义：在代码运行时通过反射来动态地生成代理类的对象，并确定到底代理谁，也就是我们在编码阶段无需知道代理谁
* 代理谁将会在代码运行时决定，java提供了InvocationHandler
* 在动态代理类中，我们声明了一个object的引用，该引用指向被代理类，我们调用被代理类的具体方法在invoke中执行
*/
public class DynamicPurchasing implements InvocationHandler {

    private Object object;
    public DynamicPurchasing (Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(object, args);
        if (method.getName().equals("buy")){
            Log.e("TAG","动态代理:zdh在shop");
        }
        return invoke;
    }
}
