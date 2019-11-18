package com.bw.zhaozhipeng;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.zhaozhipeng.base.BaseActivity;
import com.bw.zhaozhipeng.base.BasePresenter;
import com.bw.zhaozhipeng.bean.LoginBean;
import com.bw.zhaozhipeng.bean.RegisterBean;
import com.bw.zhaozhipeng.presenter.Presenter;
import com.bw.zhaozhipeng.url.HttpUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegisterActivity extends BaseActivity {


    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    private String name;
    private String pwd;
    private EditText phone;
    private EditText password;
    private Button register;
    //手机号
    private String isphone = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    //密码
    private String ispwd = "^[0-9a-z]{6,16}$";

    @Override
    protected void initView() {


        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入的数据
                name = phone.getText().toString().trim();
                pwd = password.getText().toString().trim();

                if (name.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "请输入正确的参数", Toast.LENGTH_SHORT).show();
                } else {
                    isPhone();
                }

            }
        });

    }


    @Override
    protected int layout() {
        return R.layout.activity_register;
    }

    @Override
    public void Success(String json) {
        Gson gson = new Gson();
        RegisterBean registerBean = gson.fromJson(json, RegisterBean.class);
        String message = registerBean.getMessage();
        if (message.equals("注册成功")) {
            Toast.makeText(this, json, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "该账号已被注册", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void Filed(String error) {

    }

    private void isPhone() {
        boolean matches = Pattern.matches(isphone, name);
        boolean matches1 = Pattern.matches(ispwd, pwd);
        if (matches) {

        } else {
            Toast.makeText(this, "请输入有效的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (matches1) {

        } else {
            Toast.makeText(this, "请输入6-16位字符或数字", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, String> map = new HashMap();
        map.put("phone", name);
        map.put("pwd", pwd);
        mPresenter.POSTstart(HttpUrl.Register, map);

    }
}
