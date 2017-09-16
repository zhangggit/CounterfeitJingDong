package com.example.zhanggang.counterfeitjingdong.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhanggang.counterfeitjingdong.R;
import com.example.zhanggang.counterfeitjingdong.model.bean.ZhuCe3;
import com.example.zhanggang.counterfeitjingdong.presenter.Register3Presenter;
import com.example.zhanggang.counterfeitjingdong.view.IView.Register3View;

//注册验证码页面
public class Regiter3Activity extends AppCompatActivity implements Register3View {

    EditText editText;
    private String shoujihao;
    private String mima;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter3);

        editText = (EditText) findViewById(R.id.edtext_yanzhenma);
        button = (Button) findViewById(R.id.xiayibu_zhuce3);

        //获取传过来的手机号和密码
        Intent intent = getIntent();
        shoujihao = intent.getStringExtra("shoujihao1");
        mima = intent.getStringExtra("mima");

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String yanzhengma = editText.getText().toString();
                Register3Presenter register3Presenter = new Register3Presenter(Regiter3Activity.this, shoujihao, mima, yanzhengma);
                register3Presenter.getRegister3Data();
            }
        });
    }

    //退出
    public void on_zhuce_tuichu(View view) {
        finish();
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onDataSucced(ZhuCe3 zhuCe3) {
        int code = zhuCe3.code;
        if (code == 1) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Regiter3Activity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Regiter3Activity.this, "注册失败！", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onDataFailed(String ex) {

    }
}
