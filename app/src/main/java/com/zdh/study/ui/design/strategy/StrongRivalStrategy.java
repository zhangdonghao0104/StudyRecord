package com.zdh.study.ui.design.strategy;

import android.util.Log;
/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/3/21 13:13
* description:第二步 具体的策略实现
*/
public class StrongRivalStrategy implements FightingStrategy {
    @Override
    public void fighting() {
        Log.e("", "fighting: 对手很强，使用乾坤大挪移");
    }
}
