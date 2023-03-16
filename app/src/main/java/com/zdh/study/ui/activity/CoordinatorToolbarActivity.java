package com.zdh.study.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.zdh.study.R;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseActivity;

public class CoordinatorToolbarActivity extends BaseActivity {


//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        ActivityCoordinatorlayoutBinding binding;
//        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_coordinatorlayout);
//        ArrayList<CoordinatorData> coordinatorDataList = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            CoordinatorData coordinatorData = new CoordinatorData("我是item" + i);
//            coordinatorDataList.add(coordinatorData);
//        }
//        CoordinatorLayoutAdapter layoutAdapter = new CoordinatorLayoutAdapter(R.layout.coordinator_item, coordinatorDataList);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(CoordinatorToolbarActivity.this);
//        binding.recyclerView.setLayoutManager(layoutManager);
//        binding.recyclerView.setAdapter(layoutAdapter);
//    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return  R.layout.activity_coordinatorlayout;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
