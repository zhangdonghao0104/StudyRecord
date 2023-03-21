package com.zdh.study.ui.design;

import android.os.Bundle;

import com.zdh.study.R;
import com.zdh.study.databinding.ActivityDesignBinding;
import com.zdh.study.vm.DesignViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivityDesign extends BaseActivity <ActivityDesignBinding, DesignViewModel>{
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_design;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
