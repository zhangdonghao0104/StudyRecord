package com.zdh.study.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zdh.study.R;
import com.zdh.study.databinding.ActivityCoordinatorViewpagerBinding;
import com.zdh.study.ui.adapter.ViewPagerBindingAdapter;
import com.zdh.study.ui.fragment.CoordinatorHomeFragment;
import com.zdh.study.vm.CoordinatorViewModel;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseActivity;

public class CoordinatorViewPagerActivity extends BaseActivity<ActivityCoordinatorViewpagerBinding, CoordinatorViewModel> {
    TabFragmentPagerAdapter adapter;
    ViewPager mViewPager;
    private List<Fragment> mFragments;

    String[] mTitles = new String[]{"主页", "微博", "相册"};

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_coordinator_viewpager;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public void initData() {
        initFragment();
        initTopTab();

    }

    public class TabFragmentPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> mlist;

        public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mlist = list;
        }


        @Override
        public Fragment getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public int getCount() {
            return mlist.size();
        }
    }

    private void initTopTab() {
        binding.tabs.setupWithViewPager(binding.viewpager);
        binding.viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));
        binding.viewpager.setAdapter(new ViewPagerBindingAdapter());

        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), mFragments);
        binding.viewpager.setAdapter(adapter);

    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new CoordinatorHomeFragment());
        mFragments.add(new CoordinatorHomeFragment());
        mFragments.add(new CoordinatorHomeFragment());


//        commitAllowingStateLoss(0);
    }
//    private void commitAllowingStateLoss(int position) {
//        hideAllFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(position + "");
//        if (currentFragment != null) {
//            transaction.show(currentFragment);
//        } else {
//            currentFragment = mFragments.get(position);
//            transaction.add(R.id.frameLayout, currentFragment, position + "");
//        }
//        transaction.commitAllowingStateLoss();
//    }

    private void hideAllFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(i + "");
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
        }
        transaction.commitAllowingStateLoss();
    }

}
