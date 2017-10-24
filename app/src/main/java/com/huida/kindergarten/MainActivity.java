package com.huida.kindergarten;

import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.huida.kindergarten.adapter.MainViewPagerAdapter;
import com.huida.kindergarten.base.BaseActivity;
import com.huida.kindergarten.fragment.ClassFragment;
import com.huida.kindergarten.fragment.CommFragment;
import com.huida.kindergarten.fragment.MineFragment;
import com.huida.kindergarten.fragment.SchoolFragment;
import com.huida.kindergarten.utils.ScreenUtils;
import com.huida.kindergarten.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scout
 * Created on 2017/10/24 14:03.
 */
public class MainActivity extends BaseActivity {

    private NoScrollViewPager mViewPager;
    private RadioGroup mRgTabs;
    private Toolbar mToolbar;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    private int[] mTabResIds = {
            R.drawable.tab_class,
            R.drawable.tab_school,
            R.drawable.tab_comm,
            R.drawable.tab_mine
    };

    private int[] mRbIds = {
            R.id.id_main_rb_class,
            R.id.id_main_rb_school,
            R.id.id_main_rb_comm,
            R.id.id_main_rb_mine
    };

    @Override
    protected void initViews() {
        mViewPager = (NoScrollViewPager) findViewById(R.id.id_main_vp);
        mRgTabs = (RadioGroup) findViewById(R.id.id_main_rg_tabs);

        /*解决RadioButton图标过大的问题，动态设置大小*/
        for (int i = 0; i < mRbIds.length; i++) {
            RadioButton rb = (RadioButton) findViewById(mRbIds[i]);
            final Drawable drawable = getResources().getDrawable(mTabResIds[i]);
            final int size = (int) ScreenUtils.dp2px(24);
            drawable.setBounds(0, 0, size, size);
            rb.setCompoundDrawables(null, drawable, null, null);
        }

        initViewPagers();
    }

    private void initViewPagers() {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ClassFragment());
        fragments.add(new SchoolFragment());
        fragments.add(new CommFragment());
        fragments.add(new MineFragment());
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
        /*底部导航栏事件*/
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
