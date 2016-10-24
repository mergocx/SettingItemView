package com.utouu.settingitem;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by chenxin on 2016/10/21.
 * Fuction:
 * Desc:
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
