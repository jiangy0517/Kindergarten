package com.huida.kindergarten.fragment;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.huida.kindergarten.R;
import com.huida.kindergarten.adapter.GuideLinearAdapter;
import com.huida.kindergarten.adapter.StoryGridAdapter;
import com.huida.kindergarten.adapter.decoration.SpacesItemDecoration;
import com.huida.kindergarten.base.BaseFragment;
import com.huida.kindergarten.bean.GuideItem;
import com.huida.kindergarten.bean.SpaceSize;
import com.huida.kindergarten.bean.StoryItem;
import com.huida.kindergarten.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scout
 * Created on 2017/10/24 14:03.
 */
public class SchoolFragment extends BaseFragment {

    private static final String TAG = "SchoolFragment";
    public Toolbar mToolbar;
    @Override
    protected int getContentView() {
        return R.layout.fragment_school;
    }

    @Override
    protected void initViews(View view) {
        /*加载故事数据*/
        List<StoryItem> stories = new ArrayList<>();
        stories.add(new StoryItem("一只小羊的故事,第一章第一节", R.drawable.school_story_1));
        stories.add(new StoryItem("一只小羊的故事,第一章第一节", R.drawable.school_story_2));
        stories.add(new StoryItem("一只小羊的故事,第一章第一节", R.drawable.school_story_3));
        stories.add(new StoryItem("一只小羊的故事,第一章第一节", R.drawable.school_story_4));
        stories.add(new StoryItem("一只小羊的故事,第一章第一节", R.drawable.school_story_5));
        stories.add(new StoryItem("一只小羊的故事,第一章第一节", R.drawable.school_story_6));
        final StoryGridAdapter adapter = new StoryGridAdapter(getContext(), stories);
        RecyclerView rv = view.findViewById(R.id.id_school_rv_story);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 3,
                GridLayoutManager.VERTICAL, false));
        /*添加间距*/
        final SpaceSize spaceSize = new SpaceSize(0, 0,
                (int) ScreenUtils.dp2px(5), (int) ScreenUtils.dp2px(21));

        rv.addItemDecoration(new SpacesItemDecoration(spaceSize));
        rv.setAdapter(adapter);

        /*引导栏数据*/
        final String[] array = getResources().getStringArray(R.array.school_guide);
        List<GuideItem> guides = new ArrayList<>();
        guides.add(new GuideItem(array[0], R.mipmap.ic_school_baby_music));
        guides.add(new GuideItem(array[1], R.mipmap.ic_school_baby_samples));
        guides.add(new GuideItem(array[2], R.mipmap.ic_school_vote));
        guides.add(new GuideItem(array[3], R.mipmap.ic_school_growup));
        guides.add(new GuideItem(array[4], R.mipmap.ic_school_teacher));
        final GuideLinearAdapter guideAdapter = new GuideLinearAdapter(getContext(), guides);
        RecyclerView rvGuide = view.findViewById(R.id.id_school_rv_guide);
        rvGuide.setLayoutManager(new GridLayoutManager(getContext(), 5,
                GridLayoutManager.VERTICAL, false));
        rvGuide.setNestedScrollingEnabled(false);
        rvGuide.setAdapter(guideAdapter);

        mToolbar = (Toolbar) view.findViewById(R.id.id_main_toolbar);
        final TextView title = mToolbar.findViewById(R.id.id_toolbar_title);
        title.setText("交运里幼儿园");
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
    }

    @Override
    protected void initListeners() {

    }
}
