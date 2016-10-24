package com.chenxin.sivlibary;

import android.content.Context;

/**
 * Created by chenxin on 2016/10/24.
 * Fuction:
 * Desc:
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
