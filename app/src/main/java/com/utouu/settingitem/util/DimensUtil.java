package com.utouu.settingitem.util;

import android.content.Context;

/**
 * Created by Marno on 2016/10/17/17:18.
 * Function：各类单位工具类
 * Desc：
 * 功能列表
 * 1.将dp转换为px
 * 2.将px转换为dp
 */

public class DimensUtil {

    private DimensUtil() {

    }

    /**
     * dp转px
     *
     * @return dp对应的px值
     */
    public static int dp2px(int dp, Context context) {
        return (int) (dp * (context.getResources().getDisplayMetrics().density) + 0.5);
    }

    /**
     * px转dp
     *
     * @return px值对应的dp值
     */
    public static int px2dp(int px, Context context) {
        return (int) (px / (context.getResources().getDisplayMetrics().density) + 0.5);
    }
}
