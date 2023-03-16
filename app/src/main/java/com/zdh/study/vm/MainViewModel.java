package com.zdh.study.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.zdh.study.ui.activity.CoordinatorViewPagerActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    //登录按钮的点击事件
    public BindingCommand jumpOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(CoordinatorViewPagerActivity.class);
        }
    });
}
