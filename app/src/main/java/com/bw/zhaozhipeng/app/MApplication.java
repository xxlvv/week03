package com.bw.zhaozhipeng.app;

import android.app.Application;
import android.content.Context;

/**
 * Copyright (C)
 * <p>
 * FileName: MApplication
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/18 8:47
 * <p>
 * Description:
 */
public class MApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
