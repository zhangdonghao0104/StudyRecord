package com.zdh.study.ui.design.proxy;

import android.util.Log;
/*
* @author mousse
* create time 2023/3/21 10:10
* description:第二步，真实主题类(购买者)，实现抽象主题接口，
*/
public class Zhangdh implements IShop{
    @Override
    public void buy() {
        Log.e("TAG","消费者进行购买");
    }
}
