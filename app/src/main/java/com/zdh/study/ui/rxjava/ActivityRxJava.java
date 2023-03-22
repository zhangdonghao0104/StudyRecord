package com.zdh.study.ui.rxjava;

import android.os.Bundle;
import android.util.Log;

import com.zdh.study.BR;
import com.zdh.study.R;
import com.zdh.study.databinding.ActivityRxjavaBinding;
import com.zdh.study.vm.RxViewModel;

import org.reactivestreams.Subscriber;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivityRxJava extends BaseActivity <ActivityRxjavaBinding, RxViewModel>{
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_rxjava;
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.setOperator();
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
