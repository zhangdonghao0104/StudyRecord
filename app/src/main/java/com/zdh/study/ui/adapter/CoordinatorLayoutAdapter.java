package com.zdh.study.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zdh.study.R;
import com.zdh.study.ui.data.CoordinatorData;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutAdapter extends BaseQuickAdapter<CoordinatorData, BaseViewHolder> {
    private Context context;
    private List<CoordinatorData> arrayList = new ArrayList<>();

    public CoordinatorLayoutAdapter(int layoutResId, @Nullable List<CoordinatorData> data) {
        super(layoutResId, data);
        arrayList = data;
    }


    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, CoordinatorData coordinatorData) {
        baseViewHolder.setText(R.id.item_tv, coordinatorData.getContent());
    }

}
