package com.huida.kindergarten.adapter;

import android.content.Context;

import com.huida.kindergarten.R;
import com.huida.kindergarten.adapter.base.BaseRecycleViewAdapter;
import com.huida.kindergarten.bean.StoryItem;
import com.huida.kindergarten.view.imageview.MarkImageView;

import java.util.List;

/**
 * Created by Scout
 * Created on 2017/10/24 11:38.
 */
public class StoryGridAdapter extends BaseRecycleViewAdapter<StoryItem> {
    public StoryGridAdapter(Context context, List<StoryItem> datas) {
        super(context, datas);
    }

    @Override
    protected void convert(MyViewHolder holder, int position, StoryItem storyItem) {
        holder.setText(R.id.id_story_tv_title, storyItem.getTitle());
        MarkImageView iv = holder.getView(R.id.id_story_iv_img);
        iv.setImgRes(storyItem.getResId());
        iv.setNum((int) (Math.random() * 1000) + 1);
    }

    @Override
    protected int getItemView() {
        return R.layout.school_story_item;
    }
}
