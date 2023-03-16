package com.zdh.study.ui.activity;

import android.os.Bundle;
import android.view.View;


import androidx.lifecycle.ViewModelProviders;

import com.zdh.study.BR;
import com.zdh.study.R;
import com.zdh.study.databinding.ActivityMainBinding;
import com.zdh.study.vm.MainViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;


public class MainActivity extends BaseActivity <ActivityMainBinding, MainViewModel>{

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}