package com.zdh.study.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.zdh.study.BR;
import com.zdh.study.R;
import com.zdh.study.databinding.FragmentCoordinatorHomeBinding;
import com.zdh.study.ui.adapter.CoordinatorLayoutAdapter;
import com.zdh.study.ui.data.CoordinatorData;
import com.zdh.study.vm.CoordinatorViewModel;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseFragment;

public class CoordinatorHomeFragment extends BaseFragment<FragmentCoordinatorHomeBinding, CoordinatorViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_coordinator_home;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initData() {
        ArrayList<CoordinatorData> coordinatorDataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            CoordinatorData coordinatorData = new CoordinatorData("我是item" + i);
            coordinatorDataList.add(coordinatorData);
        }
        CoordinatorLayoutAdapter layoutAdapter = new CoordinatorLayoutAdapter(R.layout.coordinator_item, coordinatorDataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(layoutAdapter);
    }
}
