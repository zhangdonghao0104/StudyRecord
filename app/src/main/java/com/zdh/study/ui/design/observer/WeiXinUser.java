package com.zdh.study.ui.design.observer;

import android.util.Log;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/21 13:48
* description:具体观察者对象
*/
public class WeiXinUser implements Observer {

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }


    @Override
    public void update(String msg) {
        Log.e("TAG", "update: " + msg);
    }
}
