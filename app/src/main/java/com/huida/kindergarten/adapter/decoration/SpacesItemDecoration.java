package com.huida.kindergarten.adapter.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.huida.kindergarten.bean.SpaceSize;

/**
 * Created by Scout
 * Created on 2017/10/24 12:01.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private SpaceSize space;

    public SpacesItemDecoration(SpaceSize space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.right = space.getRight();
        outRect.left = space.getLeft();
        outRect.top = space.getTop();
        outRect.bottom = space.getBottom();
        if (parent.getChildLayoutPosition(view) % 3 == 2) {
            outRect.right = 0;
        }
    }
}
