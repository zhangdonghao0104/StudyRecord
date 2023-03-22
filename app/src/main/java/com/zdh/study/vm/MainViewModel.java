package com.zdh.study.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.zdh.study.ui.coordinator.ActivityCoordinator;
import com.zdh.study.ui.design.ActivityDesign;
import com.zdh.study.ui.rxjava.ActivityRxJava;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }


    public BindingCommand jumpOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityCoordinator.class);
        }
    });
    public BindingCommand jumpDesignCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityDesign.class);
        }
    });
    public BindingCommand jumpRxjavaCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityRxJava.class);
        }
    });
}
