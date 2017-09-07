package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.zhanggang.counterfeitjingdong.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 登陆页面
 */
public class DengLuActivity extends AppCompatActivity {
    @BindView(R.id.zhanghao)
    EditText phone;
    @BindView(R.id.mima)
    EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        ButterKnife.bind(this);

    }

    //点击退出页面
    public void on_denglu_tuichu(View view) {
        finish();
    }

    //登陆
    public void on_denglu(View view) {

    }

    //手机注册
    public void on_shoujizhuce(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    //QQ登陆
    public void on_qqdenglu(View view) {

    }


}
