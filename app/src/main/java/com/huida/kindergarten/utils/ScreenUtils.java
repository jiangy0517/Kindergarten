package com.huida.kindergarten.utils;

import android.content.res.Resources;

/**
 * Created by Scout
 * Created on 2017/10/24 11:44.
 */

public class ScreenUtils {
    public static double dp2px(int dp) {
        final float density = Resources.getSystem().getDisplayMetrics().density;
        return density * dp;
    }
}
