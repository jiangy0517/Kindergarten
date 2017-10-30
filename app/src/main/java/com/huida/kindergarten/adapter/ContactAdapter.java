package com.huida.kindergarten.adapter;

import android.content.Context;

import com.huida.kindergarten.R;
import com.huida.kindergarten.adapter.base.BaseRecycleViewAdapter;
import com.huida.kindergarten.bean.ContactMessage;
import com.huida.kindergarten.view.imageview.BadgeImageView;

import java.util.List;

/**
 * Created by Scout
 * Created on 2017/10/30 13:37.
 */

public class ContactAdapter extends BaseRecycleViewAdapter<ContactMessage> {
    public ContactAdapter(Context context, List<ContactMessage> datas) {
        super(context, datas);
    }

    @Override
    protected void convert(MyViewHolder holder, int position, ContactMessage contactMessage) {
        final ContactMessage message = contactMessage;
        holder.setText(R.id.id_contact_tv_title, message.getTitle());
        holder.setText(R.id.id_contact_tv_subtitle, message.getSubtitle());
        holder.setText(R.id.id_contact_tv_time, message.getTime());
        // TODO: 2017/10/30 此处暂时使用默认的头像
        BadgeImageView imageView = holder.getView(R.id.id_contact_iv_head);
        if (position == 0) {
            imageView.setImageResId(R.mipmap.ic_comm_class);
        } else {
            imageView.setImageResId(R.mipmap.ic_comm_placeholder);
        }
        if (message.isHasNewMsg()) {
            imageView.setBadgeNumber(1);
        }
    }

    @Override
    protected int getItemView() {
        return R.layout.item_comm_contact;
    }
}
