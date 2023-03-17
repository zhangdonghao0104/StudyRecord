package com.zdh.study.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.zdh.study.BR;
import com.zdh.study.R;
import com.zdh.study.ui.coordinator.ActivityCoordinatorToolbar;
import com.zdh.study.ui.coordinator.ActivityCoordinatorViewEffect;
import com.zdh.study.ui.coordinator.ActivityCoordinatorViewPager;
import com.zdh.study.ui.coordinator.ActivityCoordinatorViewPagerHead;
import com.zdh.study.ui.coordinator.ActivityCoordinatorViewPagerPlus;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class CoordinatorViewModel extends BaseViewModel {
    public CoordinatorViewModel(@NonNull Application application) {
        super(application);
    }

    public BindingCommand jumpToolbarCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityCoordinatorToolbar.class);
        }
    });
    public BindingCommand jumpViewPagerCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityCoordinatorViewPager.class);
        }
    });

    public BindingCommand jumpViewPagerPlusCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityCoordinatorViewPagerPlus.class);
        }
    });

    public BindingCommand jumpViewPagerEffectCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityCoordinatorViewEffect.class);
        }
    });
    public BindingCommand jumpViewPagerHeadCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(ActivityCoordinatorViewPagerHead.class);
        }
    });

    public final ObservableList<CoordinatorItemViewModel> observableList = new ObservableArrayList<>();
    public final ItemBinding<CoordinatorItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.coordinator_item);
}
