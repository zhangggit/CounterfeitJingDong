package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe3;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Regiter3Activity extends AppCompatActivity {

    @BindView(R.id.edtext_yanzhenma)
    EditText editText;
    private String shoujihao;
    private String mima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter3);
        //获取传过来的手机号和密码
        Intent intent = getIntent();
        shoujihao = intent.getStringExtra("shoujihao");
        mima = intent.getStringExtra("mima");

    }
    //退出
    public void on_zhuce_tuichu(View view) {
        finish();
    }
    //点击完成
    public void on_xiayibu_zhuce3(View view) {
        String urlPath="http://api.eleteam.com/v1/user/register-step3?mobile="+shoujihao+"&password="+mima+"&code="+editText.getText().toString();
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ZhuCe3 zhuCe3 = new Gson().fromJson(response.body().string(), ZhuCe3.class);
                int code = zhuCe3.code; //获得code值 判断是否成功
                if (code==1){
                    Toast.makeText(Regiter3Activity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
