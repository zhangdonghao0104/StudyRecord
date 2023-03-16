package com.zdh.study.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.zdh.study.R;

import me.goldze.mvvmhabit.base.BaseActivity;

public class CoordinatorActivity extends BaseActivity {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.coordinator_activity;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    public void toCoordinatorToolbar(View view) {

        startActivity(new Intent(CoordinatorActivity.this, CoordinatorToolbarActivity.class));
    }
    public void toCoordinatorViewPager(View view) {

        startActivity(new Intent(CoordinatorActivity.this, CoordinatorViewPagerActivity.class));
    }
}
