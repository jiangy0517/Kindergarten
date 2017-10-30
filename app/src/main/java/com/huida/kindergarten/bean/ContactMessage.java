package com.huida.kindergarten.bean;

import java.io.Serializable;

/**
 * Created by Scout
 * Created on 2017/10/30 13:35.
 */

public class ContactMessage implements Serializable {
    private static final long serialVersionUID = 5980501990607732603L;

    private String title;
    private String subtitle;
    private String headUrl;
    private String time;
    private boolean hasNewMsg = true;

    public ContactMessage(String title, String subtitle, String headUrl, String time) {
        this.title = title;
        this.subtitle = subtitle;
        this.headUrl = headUrl;
        this.time = time;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isHasNewMsg() {
        return hasNewMsg;
    }

    public void setHasNewMsg(boolean hasNewMsg) {
        this.hasNewMsg = hasNewMsg;
    }
}
