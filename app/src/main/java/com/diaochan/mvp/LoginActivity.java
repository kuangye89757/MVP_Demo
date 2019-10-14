package com.diaochan.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.diaochan.mvp.base.BaseView;
import com.diaochan.mvp.bean.UserInfo;
import com.diaochan.mvp.login.LoginContract;
import com.diaochan.mvp.login.LoginPresenter;

public class LoginActivity extends BaseView<LoginPresenter, LoginContract.View> implements View.OnClickListener {

    private EditText nameEt;
    private EditText pwdEt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initListener() {
        btn.setOnClickListener(this);
    }

    private void initView() {
        nameEt = findViewById(R.id.et_name);
        pwdEt = findViewById(R.id.et_pwd);
        btn = findViewById(R.id.bt_login);
    }

    @Override
    public LoginContract.View getContract() {
        //回调给V层
        return new LoginContract.View<UserInfo>() {
            @Override
            public void handleResult(UserInfo userInfo) {
                if (userInfo != null) {
                    Toast.makeText(LoginActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onClick(View v) {
        // 点击登录
        String name = nameEt.getText().toString();
        String pwd = pwdEt.getText().toString();

        //发起请求，让P层处理
        p.getContract().requestLogin(name, pwd);
    }
}
