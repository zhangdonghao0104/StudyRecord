package com.zdh.study.ui.coordinator;

import android.os.Bundle;


import com.zdh.study.BR;
import com.zdh.study.R;
import com.zdh.study.databinding.CoordinatorActivityBinding;
import com.zdh.study.vm.CoordinatorViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivityCoordinator extends BaseActivity<CoordinatorActivityBinding, CoordinatorViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.coordinator_activity;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();


    }
}
