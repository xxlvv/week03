package com.bw.zhaozhipeng.util;

import android.media.Image;
import android.widget.ImageView;

import com.android.volley.Request;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bw.zhaozhipeng.R;
import com.bw.zhaozhipeng.app.MApplication;

/**
 * Copyright (C)
 * <p>
 * FileName: GlideUtil
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/18 10:07
 * <p>
 * Description:
 */
public class GlideUtil {
    public static void image(String url, ImageView imageView) {
        Glide.with(MApplication.mContext)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }
}
