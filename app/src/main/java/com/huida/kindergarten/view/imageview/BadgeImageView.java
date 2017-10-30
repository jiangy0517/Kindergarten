package com.huida.kindergarten.view.imageview;

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
 * 普通带角标的ImageView
 * <p>
 * Created by Scout
 * Created on 2017/10/27 17:24.
 */

public class BadgeImageView extends FrameLayout {

    private int mImgResId;
    private int mBadgeNumber;
    private TextView mTvBadge;
    private ImageView mIvImg;

    public BadgeImageView(@NonNull Context context) {
        this(context, null);
    }

    public BadgeImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BadgeImageView);
        mBadgeNumber = typedArray.getInt(R.styleable.BadgeImageView_badgeNumber, 0);
        mImgResId = typedArray.getResourceId(R.styleable.BadgeImageView_badgeSrc, 0);
        boolean isCircle = typedArray.getBoolean(R.styleable.BadgeImageView_isCircle, false);
        typedArray.recycle();

        int layoutId = R.layout.badge_imageview;
        if (isCircle) {
            layoutId = R.layout.badge_circle_imageview;
        }
        final View view = LayoutInflater.from(context).inflate(layoutId, null, false);
        initView(view);
    }

    private void initView(View view) {
        addView(view);
        mTvBadge = view.findViewById(R.id.id_tv_badge);
        mIvImg = view.findViewById(R.id.id_iv_img);

        setImageResId(mImgResId);
        setBadgeNumber(mBadgeNumber);
    }

    public void setImageResId(int imageResId) {
        mIvImg.setImageResource(imageResId);
    }

    /**
     * 显示角标
     * 根据数字自动调整显示策略
     *
     * @param badgeNumber [-∞,0]隐藏角标、[1]显示原点角标、[2,+∞]显示数字，最大为99
     */
    public void setBadgeNumber(int badgeNumber) {
        if (badgeNumber <= 0) hideBadge();
        if (badgeNumber == 1) showBadge();
        if (badgeNumber > 1) {
            mBadgeNumber = badgeNumber;
            /*大于99依旧使用99显示*/
            if (badgeNumber > 99) badgeNumber = 99;
            mTvBadge.setText(badgeNumber + "");
            showBadge();
        }
    }

    /**
     * 显示角标实际数量（非显示数量）
     */
    public int getBadgeNumber() {
        return mBadgeNumber;
    }

    /**
     * 返回角标显示状态
     */
    public boolean getBadgeStatus() {
        return mTvBadge.getVisibility() == View.VISIBLE ? true : false;
    }

    /**
     * 隐藏角标，会清空角标值
     */
    public void hideBadge() {
        mBadgeNumber = 0;
        mTvBadge.setText("");
        mTvBadge.setVisibility(View.GONE);
    }

    /**
     * 显示角标
     */
    public void showBadge() {
        mBadgeNumber = 0;
        mTvBadge.setVisibility(VISIBLE);
    }
}
