package com.bw.zhaozhipeng.presenter;

import com.bw.zhaozhipeng.Contract;
import com.bw.zhaozhipeng.base.BasePresenter;
import com.bw.zhaozhipeng.model.Model;

import java.util.Map;

/**
 * Copyright (C)
 * <p>
 * FileName: Presenter
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/18 8:57
 * <p>
 * Description:
 */
public class Presenter extends BasePresenter {

    private Model model;

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void GETstart(String url) {

    }

    @Override
    public void POSTstart(String url, Map<String, String> map) {
        model.doPOST(url, map, new Contract.ModelShared() {
            @Override
            public void Success(String json) {
                getView().Success(json);
            }

            @Override
            public void Filed(String error) {
                getView().Filed(error);
            }
        });
    }
}
