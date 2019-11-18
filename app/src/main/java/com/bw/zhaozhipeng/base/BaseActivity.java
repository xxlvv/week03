package com.bw.zhaozhipeng.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.zhaozhipeng.Contract;

/**
 * Copyright (C)
 * <p>
 * FileName: BaseActivity
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/18 8:58
 * <p>
 * Description:
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.IView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layout() != 0) {
            setContentView(layout());
            initView();
            mPresenter = initPresenter();
            if (mPresenter != null) {
                mPresenter.onAttch(this);
            }
            startCoding();
        }
    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int layout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onEnd();
        }
    }
}
