package com.zdh.study.ui.design.factory;

import android.os.Bundle;

import com.zdh.study.R;
import com.zdh.study.databinding.ActivityFactoryBinding;
import com.zdh.study.ui.design.factory.simple.ComputerFactory;
import com.zdh.study.ui.design.factory.simple.GDComputerFactory;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.base.BaseViewModel;

public class ActivityFactory extends BaseActivity <ActivityFactoryBinding, BaseViewModel>{
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_factory;
    }

    @Override
    public void initData() {
        super.initData();
        //简单工厂模式
        ComputerFactory.createComputer("hp").start();
        ComputerFactory.createComputer("lenovo").start();
        ComputerFactory.createComputer("asus").start();
        //工厂方法模式
        GDComputerFactory gdComputerFactory = new GDComputerFactory();
        LenovoComputer lenovoComputer = gdComputerFactory.createComputer(LenovoComputer.class);
        lenovoComputer.start();
        HpComputer hpComputer = gdComputerFactory.createComputer(HpComputer.class);
        hpComputer.start();


    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
