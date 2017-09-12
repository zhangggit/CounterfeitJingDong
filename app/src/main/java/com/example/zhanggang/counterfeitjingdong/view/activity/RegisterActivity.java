package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.EditText;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe1;
import com.google.gson.Gson;

import java.io.IOException;

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
public class RegisterActivity extends AppCompatActivity {

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
        String urlPath ="http://api.eleteam.com/v1/user/register-step1?mobile="+ editText.getText().toString();
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                ZhuCe1 zhuCe1 = new Gson().fromJson(string, ZhuCe1.class);
                int code = zhuCe1.code; //获得code值 判断是否成功
                if (code==1){
                    Intent intent = new Intent(RegisterActivity.this,Register2Activity.class);
                    //将手机号存入intent
                    intent.putExtra("shoujihao",editText.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    //退出注册
    public void on_zhuce_tuichu(View view) {
        finish();
    }

}
