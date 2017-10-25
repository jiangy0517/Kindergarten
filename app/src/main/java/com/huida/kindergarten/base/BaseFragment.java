package com.huida.kindergarten.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Scout
 * Created on 2017/10/23 16:36.
 */

abstract public class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";

    /**上下文*/
    protected FragmentActivity mActivity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentView(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initViews(view);
        initListeners();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 返回需要显示的布局
     */
    protected abstract int getContentView();

    /**
     * 初始化需要的Views
     * @param view
     */
    protected abstract void initViews(View view);

    /**
     * 初始化监听器
     */
    protected abstract void initListeners();
}
