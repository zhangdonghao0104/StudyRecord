package com.zdh.study.ui.coordinator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.zdh.study.R;
import com.zdh.study.databinding.ActivityCoordinatorViewpagerBinding;
import com.zdh.study.ui.fragment.CoordinatorHomeFragment;
import com.zdh.study.vm.CoordinatorViewModel;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.base.BaseActivity;

public class ActivityCoordinatorViewPager extends BaseActivity<ActivityCoordinatorViewpagerBinding, CoordinatorViewModel> {
    TabFragmentPagerAdapter adapter;
    ViewPager mViewPager;
    private List<Fragment> mFragments;

    String[] mTitles = new String[]{"主页", "微博", "相册"}; //标题列表
    ArrayList<String> titleList= new ArrayList<String>();
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
        private List<String> titleList;

        public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list, ArrayList<String> titleList) {
            super(fm);
            this.mlist = list;
            this.titleList = titleList;
        }


        @Override
        public Fragment getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

    private void initTopTab() {
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), mFragments,titleList);
        binding.viewpager.setAdapter(adapter);

        binding.tabs.setupWithViewPager(binding.viewpager);

    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new CoordinatorHomeFragment());
        mFragments.add(new CoordinatorHomeFragment());

        titleList.add("武侠");
        titleList.add("科幻");

    }

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
