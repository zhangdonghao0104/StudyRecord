package com.zdh.study.ui.design.factory;

import android.util.Log;

/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/20 13:14
* description:工厂设计模式-具体产品类
*/
public class AsusComputer extends Computer{
    @Override
    public void start() {
        Log.e("TAG", "start: AsusComputer");
    }
}
