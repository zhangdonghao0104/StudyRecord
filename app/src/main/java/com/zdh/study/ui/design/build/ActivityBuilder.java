package com.zdh.study.ui.design.build;

import android.os.Bundle;

import com.zdh.study.R;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivityBuilder extends BaseActivity {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_builder;
    }

    @Override
    public void initData() {
        super.initData();
        MoonComputerBuilder moonComputerBuilder = new MoonComputerBuilder();
        Director director = new Director(moonComputerBuilder);
        director.CreateComputer("i5","晓龙","天机");
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
