package com.zdh.study.ui.design.strategy;

import android.util.Log;

public class CommonRivalStrategy implements FightingStrategy {
    @Override
    public void fighting() {
        Log.e("", "fighting: 对手普通，使用太极剑");
    }
}
