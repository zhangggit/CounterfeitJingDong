package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.UrlUtile;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe2;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Register2Activity extends AppCompatActivity {

    EditText editText;
    private String shoujihao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        editText= (EditText) findViewById(R.id.edtext_mima);

        //获取传过来的手机号
        Intent intent = getIntent();
        shoujihao = intent.getStringExtra("shoujihao");

    }
    //点击下一步
    public void on_xiayibu_zhuce2(View view) {
        String urlPath ="http://api.eleteam.com/v1/user/register-step1?mobile="+shoujihao+"&password="+ editText.getText().toString();
        UrlUtile.sendOkHttpRequest(urlPath, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ZhuCe2 zhuCe2 = new Gson().fromJson(response.body().string(), ZhuCe2.class);
                int code = zhuCe2.code; //获得code值 判断是否成功
                if (code==1){
                    Intent intent=new Intent(Register2Activity.this,Regiter3Activity.class);
                    //将手机号和密码存入intent
                    intent.putExtra("shoujihao1",shoujihao);
                    intent.putExtra("mima",editText.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    //退出 取消
    public void on_zhuce_tuichu(View view) {
        finish();
    }
}
