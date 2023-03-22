package com.zdh.study.ui.design.strategy;

import android.util.Log;

public class WeakRivalStrategy implements FightingStrategy {
    @Override
    public void fighting() {
        Log.e("", "fighting: 对手太弱，使用七伤拳");
    }
}
