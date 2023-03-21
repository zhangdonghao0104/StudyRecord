package com.zdh.study.ui.design.instance;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 13:59
* description:饿汉式:在类加载时就完成了初始化，所以类加载较慢，但获取的对象快
*/
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return instance;
    }
}
