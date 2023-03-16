package com.zdh.study.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.zdh.study.BR;
import com.zdh.study.R;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class ViewPagerViewModel extends BaseViewModel {
    public SingleLiveEvent<String> itemClickEvent = new SingleLiveEvent<>();
    public ViewPagerViewModel(@NonNull Application application) {
        super(application);
        //模拟3个ViewPager页面
        for (int i = 1; i <= 3; i++) {
            ViewPagerItemViewModel itemViewModel = new ViewPagerItemViewModel(this, "第" + i + "个页面");
            items.add(itemViewModel);
        }
    }

    //给ViewPager添加ObservableList
    public ObservableList<ViewPagerItemViewModel> items = new ObservableArrayList<>();
    //给ViewPager添加ItemBinding
    public ItemBinding<ViewPagerItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_viewpager);
    //给ViewPager添加PageTitle
    public final BindingViewPagerAdapter.PageTitles<ViewPagerItemViewModel> pageTitles = new BindingViewPagerAdapter.PageTitles<ViewPagerItemViewModel>() {
        @Override
        public CharSequence getPageTitle(int position, ViewPagerItemViewModel item) {
            return "条目" + position;
        }
    };
    //ViewPager切换监听
    public BindingCommand<Integer> onPageSelectedCommand = new BindingCommand<>(new BindingConsumer<Integer>() {
        @Override
        public void call(Integer index) {
            ToastUtils.showShort("ViewPager切换：" + index);
        }
    });
}
