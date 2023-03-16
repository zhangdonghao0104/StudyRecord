package com.zdh.study.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.zdh.study.R;

import me.goldze.mvvmhabit.base.BaseFragment;

public class CoordinatorHomeFragment extends BaseFragment {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_coordinator_home;
    }

    @Override
    public int initVariableId() {
        return 0;
    }
}
