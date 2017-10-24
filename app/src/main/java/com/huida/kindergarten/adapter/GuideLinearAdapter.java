package com.huida.kindergarten.adapter;

import android.content.Context;

import com.huida.kindergarten.R;
import com.huida.kindergarten.adapter.base.BaseRecycleViewAdapter;
import com.huida.kindergarten.bean.GuideItem;

import java.util.List;

/**
 * Created by Scout
 * Created on 2017/10/24 14:03.
 */

public class GuideLinearAdapter extends BaseRecycleViewAdapter<GuideItem> {

    public GuideLinearAdapter(Context context, List<GuideItem> datas) {
        super(context, datas);
    }

    @Override
    protected void convert(MyViewHolder holder, int position, GuideItem guideItem) {
        holder.setText(R.id.id_guide_tv_title, guideItem.getTitle());
        holder.setImageRes(R.id.id_guide_iv_icon, guideItem.getResId());
    }

    @Override
    protected int getItemView() {
        return R.layout.school_guide_item;
    }
}
