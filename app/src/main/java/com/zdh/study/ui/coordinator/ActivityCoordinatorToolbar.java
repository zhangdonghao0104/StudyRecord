package com.zdh.study.ui.coordinator;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;


import com.chad.library.BR;
import com.zdh.study.R;
import com.zdh.study.databinding.ActivityCoordinatorlayoutBinding;
import com.zdh.study.ui.data.CoordinatorData;
import com.zdh.study.vm.CoordinatorItemViewModel;
import com.zdh.study.vm.CoordinatorViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivityCoordinatorToolbar extends BaseActivity<ActivityCoordinatorlayoutBinding, CoordinatorViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_coordinatorlayout;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(ActivityCoordinatorToolbar.this));
        for (int i = 0; i < 30; i++) {
            CoordinatorData coordinatorData = new CoordinatorData("条目" + i);
            CoordinatorItemViewModel itemViewModel = new CoordinatorItemViewModel(viewModel, coordinatorData);
            viewModel.observableList.add(itemViewModel);
        }
    }
}
