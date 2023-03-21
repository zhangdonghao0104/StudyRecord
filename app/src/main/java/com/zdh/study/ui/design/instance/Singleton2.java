package com.zdh.study.ui.design.instance;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 13:59
* description:懒汉式：线程安全，每次调用getinstance方法都需要进行同步，造成同步开销
*/
public class Singleton2 {

    private static Singleton2 instance ;

    private Singleton2(){

    }

    public static synchronized Singleton2 getInstance(){
        if (instance ==null){
            instance = new Singleton2();
        }
        return instance;
    }
}
