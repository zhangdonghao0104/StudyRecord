package com.zdh.study.ui.design.instance;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 13:59
* description:静态内部类单例模式
*/
public class Singleton4 {

    private Singleton4(){

    }
    public static Singleton4 getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class  SingletonHolder{
        private static final Singleton4 sInstance = new Singleton4();
    }
}
