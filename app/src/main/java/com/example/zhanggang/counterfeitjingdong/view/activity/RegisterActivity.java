package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe1;
import com.example.zhanggang.counterfeitjingdong.presenter.RegisterPresenter;
import com.example.zhanggang.counterfeitjingdong.view.IView.RegisterView;
import com.google.gson.Gson;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：注册页面  注册手机号
 * 时  间：2017/9/7 - 15:30.
 * 创建人：张刚
 */
public class RegisterActivity extends AppCompatActivity implements RegisterView {

    @BindView(R.id.edtext_shoujihao)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }

    //下一步
    public void on_xiayibu_zhuce(View view) {
        String shoujihao = editText.getText().toString();

        RegisterPresenter registerPresenter = new RegisterPresenter(this, shoujihao);
        registerPresenter.getRegsiterData();
    }

    //退出注册
    public void on_zhuce_tuichu(View view) {
        finish();
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onDateSucced(ZhuCe1 zhuCe1) {
        int code = zhuCe1.code;
        Log.e("TTTTTTT", "code++++" + code);
        if (code == 1) {
            Intent intent = new Intent(RegisterActivity.this, Register2Activity.class);
            //将手机号存入intent
            intent.putExtra("shoujihao", editText.getText().toString());
            startActivity(intent);
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(RegisterActivity.this, "手机号已存在!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onDateFailed(String ex) {

    }
}
