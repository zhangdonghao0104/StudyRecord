package com.zdh.study.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.zdh.study.ui.data.CoordinatorData;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;

public class CoordinatorItemViewModel extends ItemViewModel {
    public ObservableField<CoordinatorData> itemData = new ObservableField<>();

    public CoordinatorItemViewModel(@NonNull BaseViewModel viewModel,CoordinatorData data) {
        super(viewModel);
        itemData.set(data);
    }


}
