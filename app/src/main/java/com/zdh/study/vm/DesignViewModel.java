package com.zdh.study.vm;

import android.app.Application;

import androidx.annotation.NonNull;

import com.zdh.study.ui.design.factory.ActivityFactory;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class DesignViewModel extends BaseViewModel {
    public DesignViewModel(@NonNull Application application) {
        super(application);
    }

    public BindingCommand jumpInstanceCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityFactory.class);
        }
    });
}
