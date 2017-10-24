package com.huida.kindergarten.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.huida.kindergarten.R;

/**
 * Created by Scout
 * Created on 2017/10/24 13:21.
 */

public class MarkImageView extends FrameLayout {

    private int mImgResId;
    private int mNum;
    private TextView mTvNum;
    private ImageView mIvImg;

    public MarkImageView(@NonNull Context context) {
        this(context, null);
    }

    public MarkImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MarkImageView);

        mImgResId = typedArray.getResourceId(R.styleable.MarkImageView_img, R.mipmap.ic_launcher_round);
        mNum = typedArray.getInt(R.styleable.MarkImageView_num, 0);

        typedArray.recycle();

        initView(context);
    }

    private void initView(Context context) {
        final View view = LayoutInflater.from(context).inflate(R.layout.mark_imageview, null, false);
        addView(view);
        mTvNum = view.findViewById(R.id.id_markiv_tv_num);
        mIvImg = view.findViewById(R.id.id_markiv_iv_img);
    }

    public void setNum(int n) {
        if (n > 0) mNum = n;
        mTvNum.setText(" "+mNum);
    }

    public void setImgRes(int resId) {
        mImgResId = resId;
        mIvImg.setImageResource(mImgResId);
    }
}
