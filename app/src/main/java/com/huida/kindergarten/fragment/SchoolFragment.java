package com.huida.kindergarten.fragment;

import android.view.View;
import android.widget.Toast;

import com.huida.kindergarten.R;
import com.huida.kindergarten.base.BaseFragment;

public class SchoolFragment extends BaseFragment {

    private static final String TAG = "SchoolFragment";

    @Override
    protected int getContentView() {
        return R.layout.fragment_school;
    }

    @Override
    protected void initViews(View view) {
        Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initListeners() {

    }
}
