package com.huida.kindergarten.bean;

/**
 * Created by Scout
 * Created on 2017/10/24 9:33.
 */

public class GuideItem {
    private String title;
    private int resId;

    public GuideItem(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
