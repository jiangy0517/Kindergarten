package com.huida.kindergarten;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.huida.kindergarten.adapter.MainViewPagerAdapter;
import com.huida.kindergarten.base.BaseActivity;
import com.huida.kindergarten.fragment.SchoolFragment;
import com.huida.kindergarten.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private NoScrollViewPager mViewPager;
    private RadioGroup mRgTabs;
    private Toolbar mToolbar;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mViewPager = (NoScrollViewPager) findViewById(R.id.id_main_vp);
        mRgTabs = (RadioGroup) findViewById(R.id.id_main_rg_tabs);

        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SchoolFragment());
        fragments.add(new SchoolFragment());
        fragments.add(new SchoolFragment());
        fragments.add(new SchoolFragment());
        final MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(adapter);
        /*禁止滑动*/
        mViewPager.setScroll(false);
        /*增加缓存页面数量*/
        mViewPager.setOffscreenPageLimit(fragments.size() - 1);

        /*默认选中第一个选项卡*/
        mRgTabs.check(R.id.id_main_rb_class);

        mToolbar = (Toolbar) findViewById(R.id.id_main_toolbar);
        final TextView title = mToolbar.findViewById(R.id.id_toolbar_title);
        title.setText("交运里幼儿园");
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void initListeners() {
        mRgTabs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.id_main_rb_class:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.id_main_rb_school:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.id_main_rb_comm:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.id_main_rb_mine:
                        mViewPager.setCurrentItem(3);
                        break;
                }
            }
        });
    }
}
