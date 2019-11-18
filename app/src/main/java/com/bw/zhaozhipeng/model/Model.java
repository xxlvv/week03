package com.bw.zhaozhipeng.model;

import com.bw.zhaozhipeng.Contract;
import com.bw.zhaozhipeng.util.NetUtil;

import java.util.Map;

/**
 * Copyright (C)
 * <p>
 * FileName: Model
 * <p>
 * Author: zhaozhipeng
 * <p>
 * Date: 2019/11/18 8:54
 * <p>
 * Description:
 */
public class Model implements Contract.ModelInter {
    @Override
    public void doGET(String url, Contract.ModelShared modelShared) {

    }

    @Override
    public void doPOST(String url, final Map<String, String> map, final Contract.ModelShared modelShared) {
        NetUtil.getInstance().doPOST(url, map, new NetUtil.Shared() {
            @Override
            public void Success(String json) {
                modelShared.Success(json);
            }

            @Override
            public void Filed(String error) {
                modelShared.Filed(error);
            }
        });
    }
}
