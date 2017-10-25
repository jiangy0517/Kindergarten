package com.huida.kindergarten.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.huida.kindergarten.R;
import com.squareup.picasso.Picasso;
import com.w4lle.library.NineGridAdapter;

import java.util.List;

/**
 * Created by 81521 on 2017/10/25.
 */

public class NineLayoutAdapter extends NineGridAdapter {
    public NineLayoutAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public int getCount() {
        return (list == null) ? 0 : list.size();

    }

    @Override
    public String getUrl(int position) {
        return getItem(position) == null ? null : ((String)getItem(position));
    }

    @Override
    public Object getItem(int position) {
        return (list == null) ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view) {
        ImageView iv = new ImageView(context);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setBackgroundColor(Color.parseColor("#f5f5f5"));
        Picasso.with(context).load(getUrl(i)).fit().placeholder(R.mipmap.temp_shuoshuo).into(iv);
        return iv;
    }
}
