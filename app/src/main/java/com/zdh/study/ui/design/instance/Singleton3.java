package com.zdh.study.ui.design.instance;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 13:59
* description:双重检查模式
* 两次判空：第一次为了不必要的同步
* 第二次位null时创建实例，
*/
public class Singleton3 {

    private static volatile Singleton3 instance ;

    private Singleton3(){

    }

    public static  Singleton3 getInstance(){
        if (instance ==null){
            synchronized (Singleton3.class){
                if (instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
