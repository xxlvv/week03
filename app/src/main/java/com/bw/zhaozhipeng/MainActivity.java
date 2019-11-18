package com.bw.zhaozhipeng;


import android.widget.ImageView;
import android.widget.TextView;

import com.bw.zhaozhipeng.base.BaseActivity;
import com.bw.zhaozhipeng.base.BasePresenter;
import com.bw.zhaozhipeng.presenter.Presenter;
import com.bw.zhaozhipeng.util.GlideUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    private ImageView iv;
    private TextView name;

    @Override
    protected void initView() {


        iv = findViewById(R.id.iv);
        name = findViewById(R.id.name);

        String image = getIntent().getStringExtra("image");
        String name1 = getIntent().getStringExtra("name");

        GlideUtil.image(image,iv);

        name.setText(name1);
    }

    @Override
    protected int layout() {
        return R.layout.activity_main;
    }

    @Override
    public void Success(String json) {

    }

    @Override
    public void Filed(String error) {

    }
}
