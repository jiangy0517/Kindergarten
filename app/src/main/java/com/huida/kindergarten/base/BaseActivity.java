package com.huida.kindergarten.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Scout
 * Created on 2017/10/23 16:36.
 */

abstract public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(getContentView());
        initViews();
        initListeners();
    }

    /**
     * 在显示布局前所做的操作
     * 例如全屏、状态栏透明等工作
     */
    protected void beforeSetContentView() {
    }

    /**
     * 返回Activity显示的布局
     */
    protected abstract int getContentView();

    /**
     * 初始化需要的Views
     */
    protected abstract void initViews();

    /**
     * 初始化监听器
     */
    protected abstract void initListeners();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
