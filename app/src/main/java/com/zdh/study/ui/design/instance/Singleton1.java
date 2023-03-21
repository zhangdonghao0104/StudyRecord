package com.zdh.study.ui.design.instance;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 13:59
* description:懒汉式：线程不安全，声明一个静态对象，在用户第一次调用时初始化，这虽然节约了资源，但是第一次加载时需要初始化
* 反应稍慢，而且在多线程时不能正常工作
*/
public class Singleton1 {

    private static Singleton1 instance ;

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        if (instance ==null){
            instance = new Singleton1();
        }
        return instance;
    }
}
